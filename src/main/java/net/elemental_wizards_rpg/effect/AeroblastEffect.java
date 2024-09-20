package net.elemental_wizards_rpg.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.Vec3d;

public class AeroblastEffect extends StatusEffect {
    protected AeroblastEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void onApplied(LivingEntity entity, int amplifier) {
        super.onApplied(entity, amplifier);
            Vec3d currentMovement = entity.getVelocity();
            entity.setVelocity(currentMovement.x, currentMovement.y + 0.5F, currentMovement.z);
            entity.velocityModified = true;
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING,20,0,false,false,false));

    }
}
