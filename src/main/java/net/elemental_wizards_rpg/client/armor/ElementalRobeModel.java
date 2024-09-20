package net.elemental_wizards_rpg.client.armor;

import mod.azure.azurelibarmor.common.api.client.model.GeoModel;
import net.elemental_wizards_rpg.ElementalMod;
import net.elemental_wizards_rpg.item.armor.ElementalRobe;
import net.minecraft.util.Identifier;

public class ElementalRobeModel extends GeoModel<ElementalRobe> {
    @Override
    public Identifier getModelResource(ElementalRobe object) {
        return Identifier.of(ElementalMod.MOD_ID, "geo/wizard_t1.geo.json");
    }

    @Override
    public Identifier getTextureResource(ElementalRobe armor) {
        var textureId = armor.getFirstLayerId();
        return Identifier.of(textureId.getNamespace(), "textures/armor/" + textureId.getPath() + ".png");
    }

    @Override
    public Identifier getAnimationResource(ElementalRobe animatable) {
        return null;
    }
}
