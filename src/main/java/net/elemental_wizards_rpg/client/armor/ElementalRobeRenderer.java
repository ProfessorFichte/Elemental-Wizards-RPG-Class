package net.elemental_wizards_rpg.client.armor;

import mod.azure.azurelibarmor.common.api.client.renderer.GeoArmorRenderer;
import net.elemental_wizards_rpg.item.armor.ElementalRobe;

public class ElementalRobeRenderer extends GeoArmorRenderer<ElementalRobe> {
    public ElementalRobeRenderer() {
        super(new ElementalRobeModel());
    }
}
