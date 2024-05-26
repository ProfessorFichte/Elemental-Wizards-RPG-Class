package net.elemental_wizards_rpg.item;

import net.elemental_wizards_rpg.ElementalMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.more_rpg_classes.item.MRPGCGroup;
import net.more_rpg_classes.item.MRPGCItems;

public class ElementalGroup {
    public static Identifier ID = new Identifier(ElementalMod.MOD_ID, "generic");
    public static RegistryKey<ItemGroup> ELEMENTAL_WIZARD_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(),new Identifier(ElementalMod.MOD_ID,"generic"));
    public static ItemGroup ELEMENTAL_WIZARD;

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries){
        entries.add(ElementalItems.ELEMENTAL_ESSENCE);
    }

    public static void registerItemGroups() {
        ElementalMod.LOGGER.info("Registering Item Groups for " + ElementalMod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ElementalGroup::addItemsToIngredientItemGroup);
    }
}
