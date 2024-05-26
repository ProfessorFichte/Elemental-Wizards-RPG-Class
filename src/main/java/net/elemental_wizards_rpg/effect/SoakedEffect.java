package net.elemental_wizards_rpg.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.spell_engine.particle.ParticleHelper;
import net.spell_power.api.statuseffects.SpellVulnerabilityStatusEffect;

import static net.elemental_wizards_rpg.ElementalMod.MOD_ID;
import static net.spell_engine.internals.SpellRegistry.getSpell;

public class SoakedEffect extends SpellVulnerabilityStatusEffect {
    public SoakedEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity pLivingEntity, int pAmplifier) {
        if(pLivingEntity.isOnFire()){
            pLivingEntity.removeStatusEffect(Effects.SOAKED);
            pLivingEntity.playSound(SoundEvents.BLOCK_FIRE_EXTINGUISH,2,1);
            //pLivingEntity.getEntityWorld().addParticle(ParticleTypes.LARGE_SMOKE,1,1,1,2,2,2);
            ParticleHelper.sendBatches(pLivingEntity, getSpell(new Identifier(MOD_ID, "aqua_scald")).impact[0].particles);
            ParticleHelper.sendBatches(pLivingEntity, getSpell(new Identifier(MOD_ID, "aqua_scald")).impact[1].particles);
            pLivingEntity.extinguish();
        }
        if(pLivingEntity.isInLava()){
            pLivingEntity.removeStatusEffect(Effects.SOAKED);
            pLivingEntity.playSound(SoundEvents.BLOCK_FIRE_EXTINGUISH,2,1);
            ParticleHelper.sendBatches(pLivingEntity, getSpell(new Identifier(MOD_ID, "aqua_scald")).impact[0].particles);
            ParticleHelper.sendBatches(pLivingEntity, getSpell(new Identifier(MOD_ID, "aqua_scald")).impact[1].particles);
            //pLivingEntity.getEntityWorld().addParticle(ParticleTypes.LARGE_SMOKE,1,1,1,2,2,2);
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
