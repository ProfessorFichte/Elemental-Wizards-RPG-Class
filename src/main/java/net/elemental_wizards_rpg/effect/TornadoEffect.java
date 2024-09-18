package net.elemental_wizards_rpg.effect;

import net.elemental_wizards_rpg.entity.TornadoEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.spell_power.api.statuseffects.SpellVulnerabilityStatusEffect;

public class TornadoEffect extends SpellVulnerabilityStatusEffect {
    protected TornadoEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }
    @Override
    public void applyUpdateEffect(LivingEntity entity, int pAmplifier) {
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING,1,0,false,false,false));
        float range = 5.0F;
        Box radius = new Box(entity.getX() + range,
                entity.getY() + (float) range / 3,
                entity.getZ() + range,
                entity.getX() - range,
                entity.getY() - (float) range / 3,
                entity.getZ() - range);
        for(Entity entities : entity.getEntityWorld().getOtherEntities(entity, radius, EntityPredicates.VALID_LIVING_ENTITY)){
            if (entities != null) {
                if(entities instanceof TornadoEntity tornado){
                    Vec3d currentMovementTornado = tornado.getPos();
                    entity.setVelocity(currentMovementTornado.x, currentMovementTornado.y+0.15F, currentMovementTornado.z);
                }
            } else{
                entity.removeStatusEffect(Effects.TORNADO);
            }
        }

    }
    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int pAmplifier){
        Vec3d currentMovement = entity.getVelocity();
        entity.setVelocity(currentMovement.x, currentMovement.y + 0.65F, currentMovement.z);
        entity.velocityModified = true;
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING,1,0,false,false,false));
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

}
