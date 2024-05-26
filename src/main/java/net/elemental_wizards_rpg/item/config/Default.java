package net.elemental_wizards_rpg.item.config;

import net.elemental_wizards_rpg.item.weapons.WeaponsRegister;
import net.spell_engine.api.item.ItemConfig;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Default {
    public final static ItemConfig itemConfig;

    static{
        itemConfig = new ItemConfig();
        for (var weapon: WeaponsRegister.entries) {
            itemConfig.weapons.put(weapon.name(), weapon.defaults());
        }
    }
    @SafeVarargs
    private static <T> List<T> joinLists(List<T>... lists) {
        return Arrays.stream(lists).flatMap(Collection::stream).collect(Collectors.toList());
    }
}
