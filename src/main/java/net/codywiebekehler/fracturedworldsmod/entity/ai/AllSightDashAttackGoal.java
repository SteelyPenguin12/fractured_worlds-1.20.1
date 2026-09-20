package net.codywiebekehler.fracturedworldsmod.entity.ai;

import net.codywiebekehler.fracturedworldsmod.entity.custom.AllSightEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;

public class AllSightDashAttackGoal extends Goal {
    private final AllSightEntity entity;
    private final float attackRangeMax;
    private final float attackRangeMin;
    private final double dashSpeed;

    private final int attackCooldown = (int) (2.5 * 20)/2; //must be animation length in ticks/2 (don't know why)
    private int ticksUntilNextAttack = 0;
    private boolean isDashing = false;
    private int dashMaxTimeout = 100; //maximum length in ticks to remain in dash before timing out and cancelling dash
    private int dashTimeout = 0;

    public AllSightDashAttackGoal(PathfinderMob mob, float attackRangeMax, float attackRangeMin, double dashSpeed){
        this.entity = (AllSightEntity) mob;
        this.attackRangeMax = attackRangeMax;
        this.attackRangeMin = attackRangeMin;
        this.dashSpeed = dashSpeed;

        //goal flags
        this.setFlags(EnumSet.of(
                Flag.LOOK,
                Flag.MOVE,
                Flag.JUMP));
    }
    @Override
    public boolean canUse() {
        return entity.getTarget() != null && entity.getTarget().isAlive() && !(entity.getTarget() instanceof Player player && player.isCreative()) && isTargetInRange();
    }

    @Override
    public boolean canContinueToUse() {
        //don't cancel out mid dash
        if (isDashing){
            return true;
        }
        return canUse();
    }

    @Override
    public boolean isInterruptable() {
        return false;
    }

    @Override
    public void start() {
        super.start();
        if (!this.entity.level().isClientSide) {
            System.out.println("dash attack goal start() called");
        }
        //look at target before charge up starts
        this.entity.lookAt(this.entity.getTarget(),9999,9999);
        //play dash animation before attack cooldown to show it "charging up"
        entity.setDashAttacking(true);
        ticksUntilNextAttack = attackCooldown;
        dashTimeout = 0;
    }
    @Override
    public void stop() {
        if (!this.entity.level().isClientSide) {
            System.out.println("dash attack goal stop() called");
        }
        entity.setDashAttacking(false);
        super.stop();
    }

    @Override
    public void tick() {
        super.tick();

        //keep rotated towards target during WHOLE attack (charge up and movement)
        if (this.entity.getTarget() != null){
            this.entity.lookAt(this.entity.getTarget(),9999,9999);
        }

        this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack -1, 0);
        if (ticksUntilNextAttack <= 0 && this.entity.getTarget() != null){
            checkAndAttack();
        }

        //while is dashing
        if (this.isDashing && this.entity.getTarget() != null){
            //count how long entity has been dashing for
            dashTimeout++;

            //continue with momentum to push towards target
            Vec3 direction = this.entity.getTarget().position()
                    .subtract(entity.position())
                    .normalize();
            entity.setDeltaMovement(
                    direction.x * dashSpeed,
                    this.entity.getDeltaMovement().y, //doesnt move along the y direction
                    direction.z * dashSpeed
            );

            //when arrived at target, stop dashing and deal damage
            if (entity.getTarget().distanceTo(entity) <= 2.0F){
                dashHit();
                dashCancel();
            }
            //if entity has been dashing for too long, cancel dash without dealing damage
            else if (dashTimeout >= dashMaxTimeout) {
                if (!this.entity.level().isClientSide) {
                    System.out.println("dash attack goal timout reached");
                }
                dashCancel();
            }
        }
    }

    /**
     * performs all checks and attempts to make a single shout attack
     */
    private void checkAndAttack(){
        if (canUse() && !isDashing){
            //set entity to start moving towards target
            this.isDashing = true;
            dashTimeout = 0;
        }else{
            entity.setDashAttacking(false);
        }
    }

    //calculation for the range enemy must be in to be attacked with this attack, has both a min and max range
    private boolean isTargetInRange(){
        return (entity.getTarget().distanceTo(entity) <= attackRangeMax) && (entity.getTarget().distanceTo(entity) >= attackRangeMin);
    }

    /**
     * runs when a dash successfully hits, does:
     * - damage to target
     * - knockback to target
     */
    private void dashHit(){
        Vec3 direction = this.entity.getTarget().position()
                .subtract(entity.position())
                .normalize();
        //deal direct damage to target
        this.entity.getTarget().hurt(this.entity.level().damageSources().mobAttack(this.entity), (float) this.entity.getAttributeValue(Attributes.ATTACK_DAMAGE));
        //deal knockback to target in direction away from allsight
        this.entity.getTarget().knockback(1.5D, -direction.x, -direction.z);
    }
    /**
     * runs whenever a dash is finished, either cancelled early, or sucessfully
     */
    private void dashCancel(){
        //reset attack cooldown
        this.ticksUntilNextAttack = this.attackCooldown;
        //stop animation
        entity.setDashAttacking(false);

        //stop dash attack
        this.isDashing = false;
        this.dashTimeout = 0;
        //reset to new target and end goal
        this.entity.setTarget(null);
        stop();
    }
}
