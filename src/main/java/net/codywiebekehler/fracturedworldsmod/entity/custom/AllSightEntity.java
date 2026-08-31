package net.codywiebekehler.fracturedworldsmod.entity.custom;

import net.codywiebekehler.fracturedworldsmod.entity.ai.AllSightAttackGoal;
import net.codywiebekehler.fracturedworldsmod.entity.ai.AllSightDashAttackGoal;
import net.codywiebekehler.fracturedworldsmod.entity.ai.AllSightShoutAttackGoal;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import javax.naming.directory.Attribute;

public class AllSightEntity extends Monster {
    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(AllSightEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> SHOUT_ATTACKING =
            SynchedEntityData.defineId(AllSightEntity.class, EntityDataSerializers.BOOLEAN);

    public AllSightEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;
    public final AnimationState shoutAnimationState = new AnimationState();
    public int shoutAnimationTimeout = 0;

    @Override
    protected void registerGoals() {
        //navigation/etc
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 0.25f));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class,8f));
        //attacks
        this.goalSelector.addGoal(1, new AllSightAttackGoal(this, 1.0D, true, 5.0F));
        this.goalSelector.addGoal(2, new AllSightShoutAttackGoal(this, 10.0F, 5.0F));
        this.goalSelector.addGoal(3, new AllSightDashAttackGoal(this, 999.0F, 10.0F, 1.5D));
        //target selector
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ArmorStand.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide()){
            setupAnimationStates();
        }

        //sets target to null if target dies or is in creative mode
        if (this.getTarget() != null) {
            if (!this.getTarget().isAlive()
                    || (this.getTarget() instanceof Player player && player.isCreative())) {

                this.setTarget(null);
            }
        }

        /*
        if (!this.level().isClientSide) {
            if (this.getTarget() != null) {
                System.out.println("Target: " + this.getTarget().getName().getString());
            } else {
                System.out.println("NO TARGET");
            }
        }*/
    }

    private void setupAnimationStates(){
        if (this.idleAnimationTimeout <= 0){
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.tickCount);
        }else {
            --this.idleAnimationTimeout;
        }

        //starts the attack animation every time it finishes while the networked attack variable says the attack is still going
        //while also not overlapping animations by waiting the duration of the animation
        if (this.isAttacking() && attackAnimationTimeout <= 0){
            attackAnimationTimeout = 30; //length in ticks of attack animation
            attackAnimationState.start(this.tickCount);
        }else {
            --this.attackAnimationTimeout;
        }
        if (this.isShoutAttacking() && shoutAnimationTimeout <= 0){
            shoutAnimationTimeout = 50; //length in ticks of shout animation
            shoutAnimationState.start(this.tickCount);
        }else{
            --this.shoutAnimationTimeout;
        }

        //stops the attack animations when networked variable says the attack is stopping
        if (!this.isAttacking()){
            attackAnimationState.stop();
        }
        if (!this.isShoutAttacking()){
            shoutAnimationState.stop();
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

    //getters and setters for networked attacking state booleans
    public void setAttacking(boolean attacking){
        this.entityData.set(ATTACKING, attacking);
    }
    public boolean isAttacking(){
        return this.entityData.get(ATTACKING);
    }
    public void setShoutAttacking(boolean shoutAttacking){
        this.entityData.set(SHOUT_ATTACKING, shoutAttacking);
    }
    public boolean isShoutAttacking(){
        return this.entityData.get(SHOUT_ATTACKING);
    }


    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACKING,false);
        this.entityData.define(SHOUT_ATTACKING,false);
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
