package net.elemental_wizards_rpg.item;

import net.elemental_wizards_rpg.ElementalMod;
import net.elemental_wizards_rpg.item.armor.Armors;
import net.elemental_wizards_rpg.item.weapons.WeaponsRegister;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.more_rpg_classes.MRPGCMod;
import net.spell_engine.api.item.trinket.SpellBooks;

import java.util.HashMap;

public class ElementalItems {
    public static final HashMap<String, Item> entries;
    static {
        entries = new HashMap<>();
        for(var weaponEntry: WeaponsRegister.entries) {
            entries.put(weaponEntry.id().toString(), weaponEntry.item());
        }
        for(var entry: Armors.entries) {
            var set = entry.armorSet();
            for (var piece: set.pieces()) {
                var armorItem = (ArmorItem) piece;
                entries.put(set.idOf(armorItem).toString(), armorItem);
            }
        }
    }

    public static Item ELEMENTAL_ESSENCE = new Item(new FabricItemSettings().maxCount(64));

    public static void registerModItems(){
        SpellBooks.createAndRegister(new Identifier(ElementalMod.MOD_ID,"aqua"), ElementalGroup.ELEMENTAL_WIZARD_KEY);
        SpellBooks.createAndRegister(new Identifier(ElementalMod.MOD_ID,"terra"), ElementalGroup.ELEMENTAL_WIZARD_KEY);
        SpellBooks.createAndRegister(new Identifier(ElementalMod.MOD_ID,"wind"), ElementalGroup.ELEMENTAL_WIZARD_KEY);


        Registry.register(Registries.ITEM,new Identifier(ElementalMod.MOD_ID,"elemental_essence"),ELEMENTAL_ESSENCE);
    }

}
