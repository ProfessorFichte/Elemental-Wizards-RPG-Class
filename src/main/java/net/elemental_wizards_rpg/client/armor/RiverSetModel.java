package net.elemental_wizards_rpg.client.armor;

import mod.azure.azurelibarmor.model.GeoModel;
import net.elemental_wizards_rpg.ElementalMod;
import net.elemental_wizards_rpg.item.armor.RiverSetArmor;
import net.minecraft.util.Identifier;

public class RiverSetModel extends GeoModel<RiverSetArmor> {
    @Override
    public Identifier getModelResource(RiverSetArmor object) {
        return new Identifier(ElementalMod.MOD_ID, "geo/wizard_t2.geo.json");
    }

    @Override
    public Identifier getTextureResource(RiverSetArmor armor) {
        return new Identifier(ElementalMod.MOD_ID, "textures/armor/aqua_wizard_t2.png");
    }

    @Override
    public Identifier getAnimationResource(RiverSetArmor animatable) {
        return null;
    }

}
