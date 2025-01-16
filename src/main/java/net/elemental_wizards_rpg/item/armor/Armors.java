package net.elemental_wizards_rpg.item.armor;

import net.elemental_wizards_rpg.ElementalMod;
import net.elemental_wizards_rpg.item.ElementalGroup;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvents;
import net.more_rpg_classes.custom.MoreSpellSchools;
import net.spell_engine.api.item.ItemConfig;
import net.spell_engine.api.item.armor.Armor;
import net.spell_power.api.SpellPowerMechanics;
import net.spell_power.api.SpellSchools;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class Armors {
    private static final Supplier<Ingredient> WOOL_INGREDIENTS = () -> { return Ingredient.ofItems(
            Items.WHITE_WOOL, Items.ORANGE_WOOL, Items.MAGENTA_WOOL, Items.LIGHT_BLUE_WOOL, Items.YELLOW_WOOL,
            Items.LIME_WOOL, Items.PINK_WOOL, Items.GRAY_WOOL, Items.LIGHT_GRAY_WOOL, Items.CYAN_WOOL,
            Items.PURPLE_WOOL, Items.BLUE_WOOL, Items.BROWN_WOOL, Items.GREEN_WOOL, Items.RED_WOOL, Items.BLACK_WOOL
    );
    };
    private static final Supplier<Ingredient> NETHERITE_INGREDIENTS = () -> { return Ingredient.ofItems(Items.NETHERITE_INGOT); };

    public static Armor.CustomMaterial material_elememtal = new Armor.CustomMaterial(
            "elemental",
            10,
            9,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
            WOOL_INGREDIENTS
    );

    public static Armor.CustomMaterial material_kelp = new Armor.CustomMaterial(
            "kelp",
            20,
            10,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
            WOOL_INGREDIENTS
    );

    public static Armor.CustomMaterial material_dripstone = new Armor.CustomMaterial(
            "dripstone",
            20,
            10,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
            WOOL_INGREDIENTS
    );

    public static Armor.CustomMaterial material_wind = new Armor.CustomMaterial(
            "wind",
            20,
            10,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
            WOOL_INGREDIENTS
    );

    public static Armor.CustomMaterial material_netherite_kelp = new Armor.CustomMaterial(
            "netherite_kelp",
            30,
            15,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
            NETHERITE_INGREDIENTS
    );

    public static Armor.CustomMaterial material_netherite_dripstone = new Armor.CustomMaterial(
            "netherite_dripstone",
            30,
            15,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
            NETHERITE_INGREDIENTS
    );

    public static Armor.CustomMaterial material_netherite_wind = new Armor.CustomMaterial(
            "netherite_wind",
            30,
            15,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
            NETHERITE_INGREDIENTS
    );

    public static final ArrayList<Armor.Entry> entries = new ArrayList<>();
    private static Armor.Entry create(Armor.CustomMaterial material, ItemConfig.ArmorSet defaults) {
        return new Armor.Entry(material, null, defaults);
    }

    public static final float t1RobePower = 0.2F;
    public static final float t2RobePower = 0.25F;
    private static final float t2Haste = 0.03F;
    private static final float t2CritChance = 0.02F;
    private static final float t2CritDamage = 0.10F;
    public static final float t3RobePower = 0.3F;


    public static final Armor.Set elementalArmor =
            create(material_elememtal,
                    ItemConfig.ArmorSet.with(
                            new ItemConfig.ArmorSet.Piece(1)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(MoreSpellSchools.AIR.id, t1RobePower),
                                            ItemConfig.Attribute.multiply(MoreSpellSchools.EARTH.id, t1RobePower),
                                            ItemConfig.Attribute.multiply(MoreSpellSchools.WATER.id, t1RobePower),
                                            ItemConfig.Attribute.multiply(SpellSchools.FIRE.id, t1RobePower)
                                    )),
                            new ItemConfig.ArmorSet.Piece(3)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(MoreSpellSchools.AIR.id, t1RobePower),
                                            ItemConfig.Attribute.multiply(MoreSpellSchools.EARTH.id, t1RobePower),
                                            ItemConfig.Attribute.multiply(MoreSpellSchools.WATER.id, t1RobePower),
                                            ItemConfig.Attribute.multiply(SpellSchools.FIRE.id, t1RobePower)
                                    )),
                            new ItemConfig.ArmorSet.Piece(2)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(MoreSpellSchools.AIR.id, t1RobePower),
                                            ItemConfig.Attribute.multiply(MoreSpellSchools.EARTH.id, t1RobePower),
                                            ItemConfig.Attribute.multiply(MoreSpellSchools.WATER.id, t1RobePower),
                                            ItemConfig.Attribute.multiply(SpellSchools.FIRE.id, t1RobePower)
                                    )),
                            new ItemConfig.ArmorSet.Piece(1)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(MoreSpellSchools.AIR.id, t1RobePower),
                                            ItemConfig.Attribute.multiply(MoreSpellSchools.EARTH.id, t1RobePower),
                                            ItemConfig.Attribute.multiply(MoreSpellSchools.WATER.id, t1RobePower),
                                            ItemConfig.Attribute.multiply(SpellSchools.FIRE.id, t1RobePower)
                                    ))
                    ))   .bundle(material -> new Armor.Set<>(ElementalMod.MOD_ID,
                            new ElementalRobe(material, ArmorItem.Type.HELMET, new Item.Settings()),
                            new ElementalRobe(material, ArmorItem.Type.CHESTPLATE, new Item.Settings()),
                            new ElementalRobe(material, ArmorItem.Type.LEGGINGS, new Item.Settings()),
                            new ElementalRobe(material, ArmorItem.Type.BOOTS, new Item.Settings())
                    ))
                    .put(entries).armorSet();

    public static final Armor.Set kelpArmor =
            create(material_kelp,
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
                    ))   .bundle(material -> new Armor.Set<>(ElementalMod.MOD_ID,
                            new ElementalRobe(material, ArmorItem.Type.HELMET, new Item.Settings()),
                            new ElementalRobe(material, ArmorItem.Type.CHESTPLATE, new Item.Settings()),
                            new ElementalRobe(material, ArmorItem.Type.LEGGINGS, new Item.Settings()),
                            new ElementalRobe(material, ArmorItem.Type.BOOTS, new Item.Settings())
                    ))
                    .put(entries).armorSet();

    public static final Armor.Set dripstoneArmor =
            create(material_dripstone,
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
                    ))   .bundle(material -> new Armor.Set<>(ElementalMod.MOD_ID,
                            new ElementalRobe(material, ArmorItem.Type.HELMET, new Item.Settings()),
                            new ElementalRobe(material, ArmorItem.Type.CHESTPLATE, new Item.Settings()),
                            new ElementalRobe(material, ArmorItem.Type.LEGGINGS, new Item.Settings()),
                            new ElementalRobe(material, ArmorItem.Type.BOOTS, new Item.Settings())
                    ))
                    .put(entries).armorSet();

    public static final Armor.Set windArmor =
            create(material_wind,
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
                    ))   .bundle(material -> new Armor.Set<>(ElementalMod.MOD_ID,
                            new ElementalRobe(material, ArmorItem.Type.HELMET, new Item.Settings()),
                            new ElementalRobe(material, ArmorItem.Type.CHESTPLATE, new Item.Settings()),
                            new ElementalRobe(material, ArmorItem.Type.LEGGINGS, new Item.Settings()),
                            new ElementalRobe(material, ArmorItem.Type.BOOTS, new Item.Settings())
                    ))
                    .put(entries).armorSet();

    public static final Armor.Set netheriteKelpArmor =
            create(material_netherite_kelp,
                    ItemConfig.ArmorSet.with(
                            new ItemConfig.ArmorSet.Piece(1)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(MoreSpellSchools.WATER.id, t3RobePower),
                                            ItemConfig.Attribute.multiply(SpellPowerMechanics.HASTE.id, t2Haste)
                                    )),
                            new ItemConfig.ArmorSet.Piece(3)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(MoreSpellSchools.WATER.id, t3RobePower),
                                            ItemConfig.Attribute.multiply(SpellPowerMechanics.HASTE.id, t2Haste)
                                    )),
                            new ItemConfig.ArmorSet.Piece(2)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(MoreSpellSchools.WATER.id, t3RobePower),
                                            ItemConfig.Attribute.multiply(SpellPowerMechanics.HASTE.id, t2Haste)
                                    )),
                            new ItemConfig.ArmorSet.Piece(1)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(MoreSpellSchools.WATER.id, t3RobePower),
                                            ItemConfig.Attribute.multiply(SpellPowerMechanics.HASTE.id, t2Haste)
                                    ))
                    ))   .bundle(material -> new Armor.Set<>(ElementalMod.MOD_ID,
                            new ElementalRobe(material, ArmorItem.Type.HELMET, new Item.Settings()),
                            new ElementalRobe(material, ArmorItem.Type.CHESTPLATE, new Item.Settings()),
                            new ElementalRobe(material, ArmorItem.Type.LEGGINGS, new Item.Settings()),
                            new ElementalRobe(material, ArmorItem.Type.BOOTS, new Item.Settings())
                    ))
                    .put(entries).armorSet();

    public static final Armor.Set netheriteDripstoneArmor =
            create(material_netherite_dripstone,
                    ItemConfig.ArmorSet.with(
                            new ItemConfig.ArmorSet.Piece(1)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(MoreSpellSchools.EARTH.id, t3RobePower),
                                            ItemConfig.Attribute.multiply(SpellPowerMechanics.CRITICAL_CHANCE.id, t2CritChance)
                                    )),
                            new ItemConfig.ArmorSet.Piece(3)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(MoreSpellSchools.EARTH.id, t3RobePower),
                                            ItemConfig.Attribute.multiply(SpellPowerMechanics.CRITICAL_CHANCE.id, t2CritChance)
                                    )),
                            new ItemConfig.ArmorSet.Piece(2)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(MoreSpellSchools.EARTH.id, t3RobePower),
                                            ItemConfig.Attribute.multiply(SpellPowerMechanics.CRITICAL_CHANCE.id, t2CritChance)
                                    )),
                            new ItemConfig.ArmorSet.Piece(1)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(MoreSpellSchools.EARTH.id, t3RobePower),
                                            ItemConfig.Attribute.multiply(SpellPowerMechanics.CRITICAL_CHANCE.id, t2CritChance)
                                    ))
                    ))   .bundle(material -> new Armor.Set<>(ElementalMod.MOD_ID,
                            new ElementalRobe(material, ArmorItem.Type.HELMET, new Item.Settings()),
                            new ElementalRobe(material, ArmorItem.Type.CHESTPLATE, new Item.Settings()),
                            new ElementalRobe(material, ArmorItem.Type.LEGGINGS, new Item.Settings()),
                            new ElementalRobe(material, ArmorItem.Type.BOOTS, new Item.Settings())
                    ))
                    .put(entries).armorSet();

    public static final Armor.Set netheriteWindArmor =
            create(material_netherite_wind,
                    ItemConfig.ArmorSet.with(
                            new ItemConfig.ArmorSet.Piece(1)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(MoreSpellSchools.AIR.id, t3RobePower),
                                            ItemConfig.Attribute.multiply(SpellPowerMechanics.CRITICAL_DAMAGE.id, t2CritDamage)
                                    )),
                            new ItemConfig.ArmorSet.Piece(3)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(MoreSpellSchools.AIR.id, t3RobePower),
                                            ItemConfig.Attribute.multiply(SpellPowerMechanics.CRITICAL_DAMAGE.id, t2CritDamage)
                                    )),
                            new ItemConfig.ArmorSet.Piece(2)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(MoreSpellSchools.AIR.id, t3RobePower),
                                            ItemConfig.Attribute.multiply(SpellPowerMechanics.CRITICAL_DAMAGE.id, t2CritDamage)
                                    )),
                            new ItemConfig.ArmorSet.Piece(1)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(MoreSpellSchools.AIR.id, t3RobePower),
                                            ItemConfig.Attribute.multiply(SpellPowerMechanics.CRITICAL_DAMAGE.id, t2CritDamage)
                                    ))
                    ))   .bundle(material -> new Armor.Set<>(ElementalMod.MOD_ID,
                            new ElementalRobe(material, ArmorItem.Type.HELMET, new Item.Settings()),
                            new ElementalRobe(material, ArmorItem.Type.CHESTPLATE, new Item.Settings()),
                            new ElementalRobe(material, ArmorItem.Type.LEGGINGS, new Item.Settings()),
                            new ElementalRobe(material, ArmorItem.Type.BOOTS, new Item.Settings())
                    ))
                    .put(entries).armorSet();

    public static void register(Map<String, ItemConfig.ArmorSet> configs) {
        Armor.register(configs, entries, ElementalGroup.ELEMENTAL_WIZARD_KEY);
    }
}
