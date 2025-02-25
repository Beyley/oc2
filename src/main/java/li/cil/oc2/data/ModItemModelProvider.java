/* SPDX-License-Identifier: MIT */

package li.cil.oc2.data;

import li.cil.oc2.api.API;
import li.cil.oc2.common.entity.Entities;
import li.cil.oc2.common.item.Items;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public final class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(final DataGenerator generator, final ExistingFileHelper existingFileHelper) {
        super(generator, API.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simple(Items.WRENCH);
        simple(Items.MANUAL);

        simple(Items.NETWORK_CABLE);

        simple(Items.MEMORY_SMALL);
        simple(Items.MEMORY_MEDIUM);
        simple(Items.MEMORY_LARGE);
        simple(Items.MEMORY_EXTRALARGE);
        simple(Items.HARD_DRIVE_SMALL, "item/hard_drive_base")
            .texture("layer1", "item/hard_drive_tint");
        simple(Items.HARD_DRIVE_MEDIUM, "item/hard_drive_base")
            .texture("layer1", "item/hard_drive_tint");
        simple(Items.HARD_DRIVE_LARGE, "item/hard_drive_base")
            .texture("layer1", "item/hard_drive_tint");
        simple(Items.HARD_DRIVE_EXTRALARGE, "item/hard_drive_base")
            .texture("layer1", "item/hard_drive_tint");
        simple(Items.HARD_DRIVE_CUSTOM, "item/hard_drive_base")
            .texture("layer1", "item/hard_drive_tint");
        simple(Items.FLASH_MEMORY);
        simple(Items.FLASH_MEMORY_CUSTOM, "item/flash_memory");
        simple(Items.FLOPPY, "item/floppy_base")
            .texture("layer1", "item/floppy_tint");
        simple(Items.ZIP_DISK, "item/floppy_base")
            .texture("layer1", "item/floppy_tint");

        simple(Items.REDSTONE_INTERFACE_CARD);
        simple(Items.NETWORK_INTERFACE_CARD);
        simple(Items.FILE_IMPORT_EXPORT_CARD);
        simple(Items.SOUND_CARD);
        simple(Items.NETWORK_TUNNEL_CARD);

        simple(Items.INVENTORY_OPERATIONS_MODULE);
        simple(Items.BLOCK_OPERATIONS_MODULE);
        simple(Items.NETWORK_TUNNEL_MODULE);
        simple(Items.FILE_IMPORT_EXPORT_MODULE);

        simple(Items.TRANSISTOR);
        simple(Items.CIRCUIT_BOARD);

        withExistingParent(Entities.ROBOT.getId().getPath(), "template_shulker_box");
    }

    private <T extends Item> void simple(final RegistryObject<T> item) {
        simple(item, "item/" + item.getId().getPath());
    }

    private <T extends Item> ItemModelBuilder simple(final RegistryObject<T> item, final String texturePath) {
        return singleTexture(item.getId().getPath(),
            new ResourceLocation("item/generated"),
            "layer0",
            new ResourceLocation(API.MOD_ID, texturePath));
    }
}
