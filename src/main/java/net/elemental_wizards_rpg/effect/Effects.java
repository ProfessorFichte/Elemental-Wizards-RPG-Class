package net.elemental_wizards_rpg.effect;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.more_rpg_classes.custom.MoreSpellSchools;
import net.spell_engine.api.effect.Synchronized;
import net.spell_power.api.SpellPower;
import net.spell_power.api.SpellSchools;

import static net.elemental_wizards_rpg.ElementalMod.MOD_ID;
import static net.elemental_wizards_rpg.ElementalMod.effectsConfig;

public class Effects {
    //WATER EFFECTS
    public static StatusEffect SOAKED = new SoakedEffect(StatusEffectCategory.HARMFUL, 0x01d9cf)
            .setVulnerability(SpellSchools.LIGHTNING, new SpellPower.Vulnerability(
                    effectsConfig.value.soaked_lightning_damage_vulnerability,
                    effectsConfig.value.soaked_lightning_critical_chance_vulnerability,
                    0))
            .setVulnerability(SpellSchools.FROST, new SpellPower.Vulnerability(
                    effectsConfig.value.soaked_frost_damage_vulnerability,
                    0,
                    effectsConfig.value.soaked_frost_crit_damage_vulnerability));
    public static StatusEffect BUBBLE_FOAM = new BubbleFoamEffect(StatusEffectCategory.BENEFICIAL, 0x01d9cf);
    public static StatusEffect CLEANSING_WATER = new CleansingWaterEffect(StatusEffectCategory.BENEFICIAL, 0x01d9cf);

    //EARTH EFFECTS
    public static StatusEffect STONE_FLESH = new StoneFleshEffect(StatusEffectCategory.BENEFICIAL, 0xbd8b00);
    public static StatusEffect TREMBLING = new TremblingEffect(StatusEffectCategory.HARMFUL, 0xbd8b00);

    //AIR EFFECTS
    public static StatusEffect AEROBLAST = new AeroblastEffect(StatusEffectCategory.HARMFUL, 0xd5ebff);
    public static StatusEffect UPDRAFT = new UpdraftEffect(StatusEffectCategory.HARMFUL, 0xd5ebff)
            .setVulnerability(MoreSpellSchools.AIR, new SpellPower.Vulnerability(
                    effectsConfig.value.updraft_air_damage_vulnerability,
                    effectsConfig.value.updraft_air_spell_crit_chance_vulnerability,
                    effectsConfig.value.updraft_air_spell_crit_damage_vulnerability));
    public static StatusEffect TORNADO = new TornadoEffect(StatusEffectCategory.HARMFUL, 0xd5ebff)
            .setVulnerability(SpellSchools.FIRE, new SpellPower.Vulnerability(
                    effectsConfig.value.tornado_fire_spell_vulnerability, 0, 0));


    public static void register(){
        STONE_FLESH.addAttributeModifier(
                        EntityAttributes.GENERIC_ARMOR, "d20cbd0d-4101-4dc8-9bbc-140494951dc8",
                        effectsConfig.value.stone_flesh_armor_increase, EntityAttributeModifier.Operation.ADDITION)
                .addAttributeModifier(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, "0371dbb7-136a-471e-a7a8-512afa10389c",
                        effectsConfig.value.stone_flesh_armor_toughness_increase, EntityAttributeModifier.Operation.ADDITION);
        TREMBLING.addAttributeModifier(
                EntityAttributes.GENERIC_MOVEMENT_SPEED, "5e58808d-6042-45c6-bb4d-f5fcd82f485e",
                effectsConfig.value.trembling_movement_speed_decrease, EntityAttributeModifier.Operation.MULTIPLY_BASE);
        TORNADO.addAttributeModifier(
                EntityAttributes.GENERIC_MOVEMENT_SPEED,"5e58808d-6042-45c6-bb4d-f5fcd82f485e",
                -0.99F,EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
        UPDRAFT.addAttributeModifier(
                EntityAttributes.GENERIC_ATTACK_SPEED,"3098b421-2316-4b40-9fcf-71c84fd85fc3",
                effectsConfig.value.updraft_attack_speed_reduction,EntityAttributeModifier.Operation.MULTIPLY_TOTAL);


        Synchronized.configure(SOAKED,true);
        Synchronized.configure(CLEANSING_WATER,true);
        Synchronized.configure(BUBBLE_FOAM,true);
        Synchronized.configure(STONE_FLESH,true);
        Synchronized.configure(TREMBLING,true);
        Synchronized.configure(AEROBLAST,true);
        Synchronized.configure(UPDRAFT,true);
        Synchronized.configure(TORNADO,true);

        int effect_id =12000;
        Registry.register(Registries.STATUS_EFFECT, effect_id++, new Identifier(MOD_ID, "soaked").toString(), SOAKED);
        Registry.register(Registries.STATUS_EFFECT, effect_id++, new Identifier(MOD_ID, "cleansing_water").toString(), CLEANSING_WATER);
        Registry.register(Registries.STATUS_EFFECT, effect_id++, new Identifier(MOD_ID, "bubble_foam").toString(), BUBBLE_FOAM);
        Registry.register(Registries.STATUS_EFFECT, effect_id++, new Identifier(MOD_ID, "stone_flesh").toString(), STONE_FLESH);
        Registry.register(Registries.STATUS_EFFECT, effect_id++, new Identifier(MOD_ID, "trembling").toString(), TREMBLING);
        Registry.register(Registries.STATUS_EFFECT, effect_id++, new Identifier(MOD_ID, "aeroblast").toString(), AEROBLAST);
        Registry.register(Registries.STATUS_EFFECT, effect_id++, new Identifier(MOD_ID, "updraft").toString(), UPDRAFT);
        Registry.register(Registries.STATUS_EFFECT, effect_id++, new Identifier(MOD_ID, "tornado").toString(), TORNADO);
    }
}
