package net.codywiebekehler.fracturedworldsmod.entity.ai;

import net.codywiebekehler.fracturedworldsmod.entity.custom.AllSightEntity;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.phys.Vec3;

public class AllSightShoutAttackGoal extends Goal {

    private final AllSightEntity entity;
    private final float attackRangeMax;
    private final float attackRangeMin;
    private final int attackCooldown = 25; //must be animation length in ticks/2 (dont know why)
    private int ticksUntilNextAttack = 0;


    public AllSightShoutAttackGoal(PathfinderMob mob, float _attackRangeMax, float _attackRangeMin) {
        this.entity = (AllSightEntity) mob;
        this.attackRangeMax = _attackRangeMax;
        this.attackRangeMin = _attackRangeMin;
    }

    //determines conditions to start using this goal, only checked on goal entry
    @Override
    public boolean canUse() {
        return entity.getTarget() != null && isTargetInRange();
    }

    //determines the conditions under which this goal keeps going
    //returning false determines goal "completion" and move on to check new goal
    @Override
    public boolean canContinueToUse() {
        return entity.getTarget() != null && isTargetInRange();
    }

    @Override
    public void tick() {
        super.tick();

        //decrement till 0
        this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack -1, 0);

//        if (!this.entity.level().isClientSide) {
//            System.out.println("shout attack is ticking, ticks until next attack: "+this.ticksUntilNextAttack);
//        }

        if (ticksUntilNextAttack <= 0){
            checkAndAttack();
        }
    }

    @Override
    public boolean isInterruptable() {
        return false;
    }

    //called when goal is entered
    @Override
    public void start() {
        super.start();

        if (!this.entity.level().isClientSide) {
            System.out.println("shout attack goal start() called");
        }

        ticksUntilNextAttack = attackCooldown;
    }

    //called when goal is exited
    @Override
    public void stop() {
        entity.setShoutAttacking(false); //stops shout attack animation loop when done
        super.stop();
    }

    //calculation for the range enemy must be in to be attacked with this attack, has both a min and max range
    private boolean isTargetInRange(){
        return (entity.getTarget().distanceTo(entity) <= attackRangeMax) && (entity.getTarget().distanceTo(entity) >= attackRangeMin);
    }

    /**
     * performs all checks and attempts to make a single shout attack
     */
    private void checkAndAttack(){
        if (canUse()){
            //look at target player
            this.entity.lookAt(this.entity.getTarget(),9999,9999);
            //play shout animation
            entity.setShoutAttacking(true);
            if (!this.entity.level().isClientSide) {
                System.out.println("shout attacking set true");
            }
            //create particle trail for warden shout
            createShoutParticles(this.entity.getTarget());
            //deal direct damage to player
            this.entity.getTarget().hurt(this.entity.level().damageSources().sonicBoom(this.entity), (float) this.entity.getAttributeValue(Attributes.ATTACK_DAMAGE));
            //this.entity.doHurtTarget(this.entity.getTarget());
            //reset attack cooldown
            this.ticksUntilNextAttack = this.attackCooldown;
        }else{
            entity.setShoutAttacking(false); //cancels attack animation loop if attack fails
        }
    }

    /**
     * Draws a line of particles similar to the warden shout towards a specific target entity eminating from this AllSight
     * @param target the target to draw the shout particle trail towards
     */
    private void createShoutParticles(LivingEntity target){
        //calculates normal direction vector to target from current position
        Vec3 direction = target.getEyePosition().subtract(entity.getEyePosition()).normalize();

        //loops through making each particle in a line towards the
        for (double distance = 0; distance < this.attackRangeMax; distance += 1.0) {
            //determines vector position of current loops particle
            Vec3 particlePosition = entity.getEyePosition().add(direction.scale(distance));

            //creates actual particle by calling sendParticles on the server instance of the level
            if (entity.level() instanceof ServerLevel serverLevel){
                serverLevel.sendParticles(ParticleTypes.SONIC_BOOM, particlePosition.x,particlePosition.y,particlePosition.z,
                        1, 0,0,0,0);
            }
        }
    }
}
