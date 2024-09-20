package net.elemental_wizards_rpg.item.armor;

import net.elemental_wizards_rpg.ElementalMod;
import net.elemental_wizards_rpg.item.ElementalGroup;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.more_rpg_classes.custom.MoreSpellSchools;
import net.spell_engine.api.item.ItemConfig;
import net.spell_engine.api.item.armor.Armor;
import net.spell_power.api.SpellPowerMechanics;
import net.spell_power.api.SpellSchools;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import static net.elemental_wizards_rpg.ElementalMod.MOD_ID;

public class Armors {
    private static final Supplier<Ingredient> WOOL_INGREDIENTS = () -> { return Ingredient.ofItems(
            Items.WHITE_WOOL, Items.ORANGE_WOOL, Items.MAGENTA_WOOL, Items.LIGHT_BLUE_WOOL, Items.YELLOW_WOOL,
            Items.LIME_WOOL, Items.PINK_WOOL, Items.GRAY_WOOL, Items.LIGHT_GRAY_WOOL, Items.CYAN_WOOL,
            Items.PURPLE_WOOL, Items.BLUE_WOOL, Items.BROWN_WOOL, Items.GREEN_WOOL, Items.RED_WOOL, Items.BLACK_WOOL
    );
    };

    public static final float t1RobePower = 1.0F;
    public static final float t2RobePower = 0.25F;
    private static final float t2Haste = 0.03F;
    private static final float t2CritChance = 0.02F;
    private static final float t2CritDamage = 0.10F;


    public static RegistryEntry<ArmorMaterial> material(String name,
                                                        int protectionHead, int protectionChest, int protectionLegs, int protectionFeet,
                                                        int enchantability, RegistryEntry<SoundEvent> equipSound, Supplier<Ingredient> repairIngredient) {
        var material = new ArmorMaterial(
                Map.of(
                        ArmorItem.Type.HELMET, protectionHead,
                        ArmorItem.Type.CHESTPLATE, protectionChest,
                        ArmorItem.Type.LEGGINGS, protectionLegs,
                        ArmorItem.Type.BOOTS, protectionFeet),
                enchantability, equipSound, repairIngredient,
                List.of(new ArmorMaterial.Layer(Identifier.of(MOD_ID, name))),
                0,0
        );
        return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(MOD_ID, name), material);
    }

    public static RegistryEntry<ArmorMaterial> material_elemental = material(
            "elemental",
            1, 3, 2, 1,
            9,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, WOOL_INGREDIENTS);

    public static RegistryEntry<ArmorMaterial> material_kelp = material(
            "kelp",
            1, 3, 2, 1,
            10,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, WOOL_INGREDIENTS);

    public static RegistryEntry<ArmorMaterial> material_dripstone = material(
            "dripstone",
            1, 3, 2, 1,
            10,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, WOOL_INGREDIENTS);
    public static RegistryEntry<ArmorMaterial> material_wind = material(
            "wind",
            1, 3, 2, 1,
            10,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, WOOL_INGREDIENTS);


    public static final ArrayList<Armor.Entry> entries = new ArrayList<>();
    private static Armor.Entry create(RegistryEntry<ArmorMaterial> material, Identifier id, int durability, Armor.Set.ItemFactory factory, ItemConfig.ArmorSet defaults) {
        var entry = Armor.Entry.create(
                material,
                id,
                durability,
                factory,
                defaults);
        entries.add(entry);
        return entry;
    }

    public static final Armor.Set elementalArmor =
            create(
                    material_elemental,
                    Identifier.of(MOD_ID, "elemental"),
                    10,
                    ElementalRobe::new,
                    ItemConfig.ArmorSet.with(
                            new ItemConfig.ArmorSet.Piece(1)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.bonus(MoreSpellSchools.AIR.id, t1RobePower),
                                            ItemConfig.Attribute.bonus(MoreSpellSchools.EARTH.id, t1RobePower),
                                            ItemConfig.Attribute.bonus(MoreSpellSchools.WATER.id, t1RobePower),
                                            ItemConfig.Attribute.bonus(SpellSchools.FIRE.id, t1RobePower)
                                    )),
                            new ItemConfig.ArmorSet.Piece(3)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.bonus(MoreSpellSchools.AIR.id, t1RobePower),
                                            ItemConfig.Attribute.bonus(MoreSpellSchools.EARTH.id, t1RobePower),
                                            ItemConfig.Attribute.bonus(MoreSpellSchools.WATER.id, t1RobePower),
                                            ItemConfig.Attribute.bonus(SpellSchools.FIRE.id, t1RobePower)
                                    )),
                            new ItemConfig.ArmorSet.Piece(2)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.bonus(MoreSpellSchools.AIR.id, t1RobePower),
                                            ItemConfig.Attribute.bonus(MoreSpellSchools.EARTH.id, t1RobePower),
                                            ItemConfig.Attribute.bonus(MoreSpellSchools.WATER.id, t1RobePower),
                                            ItemConfig.Attribute.bonus(SpellSchools.FIRE.id, t1RobePower)
                                    )),
                            new ItemConfig.ArmorSet.Piece(1)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.bonus(MoreSpellSchools.AIR.id, t1RobePower),
                                            ItemConfig.Attribute.bonus(MoreSpellSchools.EARTH.id, t1RobePower),
                                            ItemConfig.Attribute.bonus(MoreSpellSchools.WATER.id, t1RobePower),
                                            ItemConfig.Attribute.bonus(SpellSchools.FIRE.id, t1RobePower)
                                    ))
                    ))
                    .armorSet();

    public static final Armor.Set kelpArmor =
            create(
                    material_kelp,
                    Identifier.of(MOD_ID, "kelp"),
                    20,
                    ElementalRobe::new,
                    ItemConfig.ArmorSet.with(
                            new ItemConfig.ArmorSet.Piece(1)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(MoreSpellSchools.WATER.id, t2RobePower),
                                            ItemConfig.Attribute.multiply(SpellPowerMechanics.HASTE.id, t2Haste)
                                    )),
                            new ItemConfig.ArmorSet.Piece(3)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(MoreSpellSchools.WATER.id, t2RobePower),
                                            ItemConfig.Attribute.multiply(SpellPowerMechanics.HASTE.id, t2Haste)
                                    )),
                            new ItemConfig.ArmorSet.Piece(2)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(MoreSpellSchools.WATER.id, t2RobePower),
                                            ItemConfig.Attribute.multiply(SpellPowerMechanics.HASTE.id, t2Haste)
                                    )),
                            new ItemConfig.ArmorSet.Piece(1)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(MoreSpellSchools.WATER.id, t2RobePower),
                                            ItemConfig.Attribute.multiply(SpellPowerMechanics.HASTE.id, t2Haste)
                                    ))
                    ))
                    .armorSet();

    public static final Armor.Set dripstoneArmor =
            create(
                    material_dripstone,
                    Identifier.of(MOD_ID, "dripstone"),
                    20,
                    ElementalRobe::new,
                    ItemConfig.ArmorSet.with(
                            new ItemConfig.ArmorSet.Piece(1)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(MoreSpellSchools.EARTH.id, t2RobePower),
                                            ItemConfig.Attribute.multiply(SpellPowerMechanics.CRITICAL_CHANCE.id, t2CritChance)
                                    )),
                            new ItemConfig.ArmorSet.Piece(3)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(MoreSpellSchools.EARTH.id, t2RobePower),
                                            ItemConfig.Attribute.multiply(SpellPowerMechanics.CRITICAL_CHANCE.id, t2CritChance)
                                    )),
                            new ItemConfig.ArmorSet.Piece(2)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(MoreSpellSchools.EARTH.id, t2RobePower),
                                            ItemConfig.Attribute.multiply(SpellPowerMechanics.CRITICAL_CHANCE.id, t2CritChance)
                                    )),
                            new ItemConfig.ArmorSet.Piece(1)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(MoreSpellSchools.EARTH.id, t2RobePower),
                                            ItemConfig.Attribute.multiply(SpellPowerMechanics.CRITICAL_CHANCE.id, t2CritChance)
                                    ))
                    ))
                    .armorSet();

    public static final Armor.Set windArmor =
            create(
                    material_wind,
                    Identifier.of(MOD_ID, "wind"),
                    20,
                    ElementalRobe::new,
                    ItemConfig.ArmorSet.with(
                            new ItemConfig.ArmorSet.Piece(1)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(MoreSpellSchools.AIR.id, t2RobePower),
                                            ItemConfig.Attribute.multiply(SpellPowerMechanics.CRITICAL_DAMAGE.id, t2CritDamage)
                                    )),
                            new ItemConfig.ArmorSet.Piece(3)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(MoreSpellSchools.AIR.id, t2RobePower),
                                            ItemConfig.Attribute.multiply(SpellPowerMechanics.CRITICAL_DAMAGE.id, t2CritDamage)
                                    )),
                            new ItemConfig.ArmorSet.Piece(2)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(MoreSpellSchools.AIR.id, t2RobePower),
                                            ItemConfig.Attribute.multiply(SpellPowerMechanics.CRITICAL_DAMAGE.id, t2CritDamage)
                                    )),
                            new ItemConfig.ArmorSet.Piece(1)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(MoreSpellSchools.AIR.id, t2RobePower),
                                            ItemConfig.Attribute.multiply(SpellPowerMechanics.CRITICAL_DAMAGE.id, t2CritDamage)
                                    ))
                    ))
                    .armorSet();

    public static void register(Map<String, ItemConfig.ArmorSet> configs) {
        Armor.register(configs, entries, ElementalGroup.ELEMENTAL_WIZARD_KEY);
    }
}
