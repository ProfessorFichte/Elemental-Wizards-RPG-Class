package net.elemental_wizards_rpg.client.armor;

import mod.azure.azurelibarmor.renderer.GeoArmorRenderer;
import net.elemental_wizards_rpg.item.armor.RiverSetArmor;

public class RiverSetRenderer extends GeoArmorRenderer<RiverSetArmor> {
    public RiverSetRenderer() {
        super(new RiverSetModel());
    }
}
