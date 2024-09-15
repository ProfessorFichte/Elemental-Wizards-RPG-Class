package net.elemental_wizards_rpg.effect;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.spell_engine.api.effect.Synchronized;
import net.spell_power.api.SpellPower;
import net.spell_power.api.SpellSchools;

import static net.elemental_wizards_rpg.ElementalMod.MOD_ID;
import static net.elemental_wizards_rpg.ElementalMod.effectsConfig;

public class Effects {

    //SOAKED
    public static StatusEffect SOAKED = new SoakedEffect(StatusEffectCategory.HARMFUL, 0x01d9cf)
            .setVulnerability(SpellSchools.LIGHTNING, new SpellPower.Vulnerability(
                    effectsConfig.value.soaked_lightning_damage_vulnerability, effectsConfig.value.soaked_lightning_critical_chance_vulnerability, 0))
            .setVulnerability(SpellSchools.FROST, new SpellPower.Vulnerability(
                    effectsConfig.value.soaked_frost_damage_vulnerability, 0.0F, effectsConfig.value.soaked_frost_crit_damage_vulnerability))
            ;

    //CleansingWater
    public static StatusEffect CLEANSING_WATER = new CleansingWaterEffect(StatusEffectCategory.BENEFICIAL, 0x01d9cf)
            ;

    //CleansingWater
    public static StatusEffect BUBBLE_FOAM = new BubbleFoamEffect(StatusEffectCategory.BENEFICIAL, 0x01d9cf)
            ;

    //Stone Flesh
    public static StatusEffect STONE_FLESH = new StoneFleshEffect(StatusEffectCategory.BENEFICIAL, 0xbd8b00);

    //Stone Flesh
    public static StatusEffect TREMBLING = new TremblingEffect(StatusEffectCategory.HARMFUL, 0xbd8b00);


    public static void register(){
        STONE_FLESH.addAttributeModifier(
                        EntityAttributes.GENERIC_ARMOR, "d20cbd0d-4101-4dc8-9bbc-140494951dc8",
                        effectsConfig.value.stone_flesh_armor_increase, EntityAttributeModifier.Operation.ADDITION)
                .addAttributeModifier(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, "0371dbb7-136a-471e-a7a8-512afa10389c",
                        effectsConfig.value.stone_flesh_armor_toughness_increase, EntityAttributeModifier.Operation.ADDITION);
        TREMBLING.addAttributeModifier(
                EntityAttributes.GENERIC_MOVEMENT_SPEED, "5e58808d-6042-45c6-bb4d-f5fcd82f485e",
                effectsConfig.value.trembling_movement_speed_decrease, EntityAttributeModifier.Operation.MULTIPLY_BASE);


        Synchronized.configure(SOAKED,true);
        Synchronized.configure(CLEANSING_WATER,true);
        Synchronized.configure(BUBBLE_FOAM,true);
        Synchronized.configure(STONE_FLESH,true);
        Synchronized.configure(TREMBLING,true);

        int effect_id =1200;
        Registry.register(Registries.STATUS_EFFECT, effect_id++, new Identifier(MOD_ID, "soaked").toString(), SOAKED);
        Registry.register(Registries.STATUS_EFFECT, effect_id++, new Identifier(MOD_ID, "cleansing_water").toString(), CLEANSING_WATER);
        Registry.register(Registries.STATUS_EFFECT, effect_id++, new Identifier(MOD_ID, "bubble_foam").toString(), BUBBLE_FOAM);
        Registry.register(Registries.STATUS_EFFECT, effect_id++, new Identifier(MOD_ID, "stone_flesh").toString(), STONE_FLESH);
        Registry.register(Registries.STATUS_EFFECT, effect_id++, new Identifier(MOD_ID, "trembling").toString(), TREMBLING);
    }
}
