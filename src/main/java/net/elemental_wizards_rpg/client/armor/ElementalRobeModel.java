package net.elemental_wizards_rpg.client.armor;

import mod.azure.azurelibarmor.model.GeoModel;
import net.elemental_wizards_rpg.ElementalMod;
import net.elemental_wizards_rpg.item.armor.ElementalRobe;
import net.minecraft.util.Identifier;

public class ElementalRobeModel extends GeoModel<ElementalRobe> {
    @Override
    public Identifier getModelResource(ElementalRobe object) {
        return new Identifier(ElementalMod.MOD_ID, "geo/wizard_t1.geo.json");
    }

    @Override
    public Identifier getTextureResource(ElementalRobe armor) {
        var texture = armor.customMaterial.name();
        return new Identifier(ElementalMod.MOD_ID, "textures/armor/" + texture + ".png");
    }

    @Override
    public Identifier getAnimationResource(ElementalRobe animatable) {
        return null;
    }
}
