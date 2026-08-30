package net.codywiebekehler.fracturedworldsmod.entity.custom;

import net.codywiebekehler.fracturedworldsmod.entity.ai.AllSightAttackGoal;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import javax.naming.directory.Attribute;

public class AllSightEntity extends Monster {
    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(AllSightEntity.class, EntityDataSerializers.BOOLEAN);

    public AllSightEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 0.25f));
        this.goalSelector.addGoal(1, new AllSightAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class,8f));

        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide()){
            setupAnimationStates();
        }

        if (!this.level().isClientSide) {
            if (this.getTarget() != null) {
                System.out.println("Target: " + this.getTarget().getName().getString());
            } else {
                System.out.println("NO TARGET");
            }
        }
    }

    private void setupAnimationStates(){
        if (this.idleAnimationTimeout <= 0){
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.tickCount);
        }else {
            --this.idleAnimationTimeout;
        }

        if (this.isAttacking() && attackAnimationTimeout <= 0){
            attackAnimationTimeout = 30; //length in ticks of attack animation
            attackAnimationState.start(this.tickCount);
        }else {
            --this.attackAnimationTimeout;
        }

        if (!this.isAttacking()){
            attackAnimationState.stop();
        }
    }

    @Override
    protected void updateWalkAnimation(float pPartialTick) {
        float f;
        if (this.getPose() == Pose.STANDING){
            f = Math.min(pPartialTick * 6F, 1F);
        }else{
            f = 0f;
        }

        this.walkAnimation.update(f,0.2f);
    }

    public void setAttacking(boolean attacking){
        this.entityData.set(ATTACKING, attacking);
    }
    public boolean isAttacking(){
        return this.entityData.get(ATTACKING);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACKING,false);
    }

    public static AttributeSupplier.Builder createAttributes(){
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 35D)
                .add(Attributes.MAX_HEALTH, 20D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D)
                .add(Attributes.ARMOR_TOUGHNESS, 0.1f)
                .add(Attributes.ARMOR, 2.0D)
                .add(Attributes.ATTACK_DAMAGE, 2F)
                .add(Attributes.ATTACK_KNOCKBACK, 1F);
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return SoundEvents.WARDEN_AMBIENT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.WARDEN_DEATH;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.WARDEN_HURT;
    }
}
