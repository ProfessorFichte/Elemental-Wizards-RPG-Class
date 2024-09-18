package net.elemental_wizards_rpg.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.Vec3d;
import net.spell_power.api.statuseffects.SpellVulnerabilityStatusEffect;

public class UpdraftEffect extends SpellVulnerabilityStatusEffect {
    protected UpdraftEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }
    public boolean ground_on_apply = false;
    @Override
    public void applyUpdateEffect(LivingEntity entity, int pAmplifier) {
        if(!entity.isOnGround()){
            Vec3d currentMovement = entity.getVelocity();
            entity.setVelocity(currentMovement.x, currentMovement.y+0.05F, currentMovement.z);
            entity.velocityModified = true;
        }
    }
    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int pAmplifier){
        if(!entity.isOnGround()){
            ground_on_apply = true;
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING,15,0,false,false,false));
        }else{
            if(entity.hasStatusEffect(Effects.UPDRAFT)){
                entity.removeStatusEffect(Effects.UPDRAFT);
            }
        }

    }
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return ground_on_apply;
    }

}
