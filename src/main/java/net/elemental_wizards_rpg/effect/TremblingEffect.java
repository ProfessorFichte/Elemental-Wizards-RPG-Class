package net.elemental_wizards_rpg.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.more_rpg_classes.effect.MRPGCEffects;

import static net.elemental_wizards_rpg.ElementalMod.effectsConfig;

public class TremblingEffect extends StatusEffect {
    protected TremblingEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }
    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if(amplifier == 3){
            entity.addStatusEffect(new StatusEffectInstance(MRPGCEffects.STUNNED.registryEntry,effectsConfig.value.trembling_stun_apply_duration * 10));
            entity.removeStatusEffect(Effects.TREMBLING.registryEntry);
        }
        return true;
    }
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
