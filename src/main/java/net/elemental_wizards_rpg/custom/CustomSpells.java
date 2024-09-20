package net.elemental_wizards_rpg.custom;

import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.spell_engine.api.spell.CustomSpellHandler;
import net.spell_engine.api.spell.SpellInfo;
import net.spell_engine.internals.SpellHelper;
import net.spell_engine.utils.TargetHelper;

import java.util.List;
import java.util.function.Predicate;

import static net.spell_engine.internals.SpellRegistry.getSpell;
import static net.elemental_wizards_rpg.ElementalMod.MOD_ID;

public class CustomSpells {
    public static void register(){
        double knockup_high_tides_caster = 0.4;
        double knockup_high_tides_targets = 0.6;

        ///WATER_SPELLS
        //HIGH_TIDES
        CustomSpellHandler.register(Identifier.of(MOD_ID, "aqua_high_tides"), (data) -> {
            CustomSpellHandler.Data data1 = (CustomSpellHandler.Data) data;
            Predicate<Entity> selectionPredicate = (target2) -> {
                return (TargetHelper.actionAllowed(TargetHelper.TargetingMode.AREA, TargetHelper.Intent.HARMFUL, data1.caster(), target2)
                );
            };
            if (!data1.caster().getWorld().isClient) {
                Vec3d currentMovementCaster = data1.caster().getVelocity();
                data1.caster().setVelocity(currentMovementCaster.x, currentMovementCaster.y + knockup_high_tides_caster, currentMovementCaster.z);
                data1.caster().velocityModified = true;
                List<Entity> list = data1.caster().getWorld().getOtherEntities(data1.caster(), data1.caster().getBoundingBox().expand(getSpell(Identifier.of(MOD_ID, "aqua_high_tides")).range), selectionPredicate);
                for (Entity entity : list) {
                    Vec3d currentMovement = entity.getVelocity();
                    entity.setVelocity(currentMovement.x, currentMovement.y + knockup_high_tides_targets, currentMovement.z);
                    entity.velocityModified = true;
                    SpellHelper.performImpacts(entity.getWorld(), data1.caster(), entity, entity, new SpellInfo(getSpell(Identifier.of(MOD_ID, "aqua_high_tides")),Identifier.of(MOD_ID)), data1.impactContext());
                    /*if(entity.isOnFire()){
                        entity.playSound(SoundEvents.BLOCK_FIRE_EXTINGUISH,1,1);
                        ParticleHelper.sendBatches(entity, getSpell(new Identifier(MOD_ID, "scald")).impact[0].particles);
                        entity.extinguish();
                    }*/
                }
            }
            return false;
        });


        ///EARTH_SPELLS
        //EARTHQUAKE
        CustomSpellHandler.register(Identifier.of(MOD_ID, "terra_earthquake"), (data) -> {
            CustomSpellHandler.Data data1 = (CustomSpellHandler.Data) data;
            Predicate<Entity> selectionPredicate = (target2) -> {
                return (TargetHelper.actionAllowed(TargetHelper.TargetingMode.AREA, TargetHelper.Intent.HARMFUL, data1.caster(), target2)
                );
            };
            if (!data1.caster().getWorld().isClient) {
                List<Entity> list = TargetHelper.targetsFromArea(data1.caster(),getSpell(Identifier.of(MOD_ID, "terra_earthquake")).range,getSpell(Identifier.of(MOD_ID, "terra_earthquake")).release.target.area, target -> TargetHelper.allowedToHurt(data1.caster(),target) );
                for (Entity entity : list) {
                    if (entity.isLiving()){
                        double minx = -1.0;
                        double maxx = 1.0;
                        double minz = -1.0;
                        double maxz = 1.0;
                        double randx = minx + Math.random() * (maxx - minx);
                        double randz = minz + Math.random() * (maxz - minz);
                        if(entity.isOnGround()){
                            Vec3d currentMovement = entity.getVelocity();
                            entity.setVelocity(currentMovement.x + randx, currentMovement.y + 0.1, currentMovement.z +randz);
                            entity.velocityModified = true;
                            SpellHelper.performImpacts(entity.getWorld(), data1.caster(), entity, entity, new SpellInfo(getSpell(Identifier.of(MOD_ID, "terra_earthquake")),Identifier.of(MOD_ID)), data1.impactContext());
                        }
                    }
                }
            }
            return false;
        });



    }
}
