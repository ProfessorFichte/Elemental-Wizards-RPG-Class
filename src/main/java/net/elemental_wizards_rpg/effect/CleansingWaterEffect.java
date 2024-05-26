package net.elemental_wizards_rpg.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.more_rpg_classes.util.CustomMethods;
import net.spell_engine.particle.ParticleHelper;

import static net.elemental_wizards_rpg.ElementalMod.MOD_ID;
import static net.spell_engine.internals.SpellRegistry.getSpell;

public class CleansingWaterEffect extends StatusEffect {
    public CleansingWaterEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }


    @Override
    public void applyUpdateEffect(LivingEntity pLivingEntity, int pAmplifier) {
        if (pLivingEntity.getHealth() < pLivingEntity.getMaxHealth()) {
            pLivingEntity.heal(1.0F);
        }
        if(pLivingEntity.isOnFire()){
            pLivingEntity.playSound(SoundEvents.BLOCK_FIRE_EXTINGUISH,2,1);
            ParticleHelper.sendBatches(pLivingEntity, getSpell(new Identifier(MOD_ID, "aqua_scald")).impact[0].particles);
            ParticleHelper.sendBatches(pLivingEntity, getSpell(new Identifier(MOD_ID, "aqua_scald")).impact[1].particles);
            pLivingEntity.extinguish();
        }
        if(pLivingEntity.isInLava()){
            pLivingEntity.removeStatusEffect(Effects.CLEANSING_WATER);
            ParticleHelper.sendBatches(pLivingEntity, getSpell(new Identifier(MOD_ID, "aqua_scald")).impact[0].particles);
            ParticleHelper.sendBatches(pLivingEntity, getSpell(new Identifier(MOD_ID, "aqua_scald")).impact[1].particles);
            pLivingEntity.playSound(SoundEvents.BLOCK_FIRE_EXTINGUISH,2,1);
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        int i;
        if (this == Effects.CLEANSING_WATER) {
            i = 35 >> amplifier;
            if (i > 0) {
                return duration % i == 0;
            } else {
                return true;
            }
        }
        return true;
    }

    @Override
    public void onApplied(LivingEntity pLivingEntity, AttributeContainer attributes, int pAmplifier){
        if(pLivingEntity.isPlayer() && pLivingEntity.getMaxHealth() == pLivingEntity.getHealth()){
            CustomMethods.clearNegativeEffects(pLivingEntity,true);
        }
    }
}
