package li.cil.oc2.client.item;

import li.cil.oc2.api.API;
import li.cil.oc2.common.item.AbstractStorageItem;
import li.cil.oc2.common.item.Items;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.util.ResourceLocation;

public final class CustomItemModelProperties {
    public static final ResourceLocation CAPACITY_PROPERTY = new ResourceLocation(API.MOD_ID, "capacity");
    public static final ResourceLocation COLOR_PROPERTY = new ResourceLocation(API.MOD_ID, "color");

    ///////////////////////////////////////////////////////////////////

    public static void initialize() {
        ItemModelsProperties.registerProperty(Items.MEMORY.get(), CustomItemModelProperties.CAPACITY_PROPERTY,
                (stack, world, entity) -> AbstractStorageItem.getCapacity(stack));

        ItemModelsProperties.registerProperty(Items.HARD_DRIVE.get(), CustomItemModelProperties.COLOR_PROPERTY,
                (stack, world, entity) -> CustomItemColors.getColor(stack));
        ItemModelsProperties.registerProperty(Items.FLOPPY.get(), CustomItemModelProperties.COLOR_PROPERTY,
                (stack, world, entity) -> CustomItemColors.getColor(stack));
    }
}
