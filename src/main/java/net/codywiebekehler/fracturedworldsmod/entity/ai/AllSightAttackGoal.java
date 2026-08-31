package net.codywiebekehler.fracturedworldsmod.entity.ai;

import net.codywiebekehler.fracturedworldsmod.entity.custom.AllSightEntity;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

import java.util.EnumSet;

public class AllSightAttackGoal extends MeleeAttackGoal {
    private final AllSightEntity entity;
    private final float attackRange;
    private int attackDelay = 30; //total delay, constant
    private int ticksUntilNextAttack = 30; //current remaining delay, variable
    private boolean shouldCountTillNextAttack = false;

    public AllSightAttackGoal(PathfinderMob pMob, double pSpeedModifier, boolean pFollowingTargetEvenIfNotSeen, float attackRange) {
        super(pMob, pSpeedModifier, pFollowingTargetEvenIfNotSeen);
        entity = (AllSightEntity)pMob;
        this.attackRange = attackRange;

        //Flags determine what aspects of the entities abilities are controlled by this attack
        //in this case this attack controls the movement and the look controls, so the AllSight cannot look or move when doing this attack
        //technically not necessary since its already extending meleeattackgoal, but eh
        this.setFlags(EnumSet.of(
                Flag.MOVE,
                Flag.LOOK));
    }

    @Override
    public boolean canUse() {
        return super.canUse();
    }
    @Override
    public boolean canContinueToUse() {
        //adds the condition of being outside of max range on top of existing meleeattackgoal stop conditions
        //stops boss from chasing you down forever once you get in melee range once
        if (this.mob.distanceTo(this.mob.getTarget()) >= this.attackRange){
            return false;
        }else {
            return super.canContinueToUse();
        }
    }

    @Override
    public void start() {
        if (!this.entity.level().isClientSide) {
            System.out.println("melee attack goal start() called");
        }
        super.start();
        attackDelay = 30;
        ticksUntilNextAttack = 30;
    }

    @Override
    protected void checkAndPerformAttack(LivingEntity pEnemy, double pDistToEnemySqr) {
        if (isEnemyWithinAttackDistance(pEnemy, pDistToEnemySqr)) {
            shouldCountTillNextAttack = true;

            if(isTimeToStartAttackAnimation()) {
                entity.setAttacking(true);
            }

            if(isTimeToAttack()) {
                this.mob.getLookControl().setLookAt(pEnemy.getX(), pEnemy.getEyeY(), pEnemy.getZ());
                performAttack(pEnemy);
            }
        } else {
            resetAttackCooldown();
            shouldCountTillNextAttack = false;
            entity.setAttacking(false);
            entity.attackAnimationTimeout = 0;
        }
    }

    private boolean isEnemyWithinAttackDistance(LivingEntity pEnemy, double pDistToEnemySqr) {
        return pDistToEnemySqr <= this.m_6639_(pEnemy);
    }

    protected void resetAttackCooldown() {
        this.ticksUntilNextAttack = this.adjustedTickDelay(attackDelay * 2);
    }

    protected boolean isTimeToAttack() {
        return this.ticksUntilNextAttack <= 0;
    }

    protected boolean isTimeToStartAttackAnimation() {
        return this.ticksUntilNextAttack <= attackDelay;
    }

    protected int getTicksUntilNextAttack() {
        return this.ticksUntilNextAttack;
    }


    protected void performAttack(LivingEntity pEnemy) {
        this.resetAttackCooldown();
        this.mob.swing(InteractionHand.MAIN_HAND);
        this.mob.doHurtTarget(pEnemy);
    }

    @Override
    public void tick() {
        super.tick();
        if(shouldCountTillNextAttack){
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack -1, 0); //decrement with some logic to stop at 0
        }
    }

    @Override
    public void stop() {
        if (!this.entity.level().isClientSide) {
            System.out.println("melee attack goal stop() called");
        }
        entity.setAttacking(false);
        super.stop();
    }
}
