package net.elemental_wizards_rpg.item.armor;

import mod.azure.azurelibarmor.animatable.GeoItem;
import mod.azure.azurelibarmor.animatable.client.RenderProvider;
import net.elemental_wizards_rpg.client.armor.ElementalRobeRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.spell_engine.api.item.armor.Armor;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class ElementalRobe extends ModArmorItem implements GeoItem {
    public ElementalRobe(Armor.CustomMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }
    @Override
    public void createRenderer(Consumer<Object> consumer) {
        consumer.accept(new RenderProvider() {
            private ElementalRobeRenderer renderer;

            @Override
            public @NotNull BipedEntityModel<LivingEntity> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, BipedEntityModel<LivingEntity> original) {
                if (renderer == null)
                    renderer = new ElementalRobeRenderer();

                renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
                return renderer;
            }
        });
    }


}