/* SPDX-License-Identifier: MIT */

package li.cil.oc2.common.item;

import li.cil.oc2.common.util.ColorUtils;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.ItemStack;

public final class FloppyItem extends AbstractStorageItem implements DyeableLeatherItem {
    private final int defaultColor;

    public FloppyItem(final int capacity, final DyeColor defaultColor) {
        super(capacity);
        this.defaultColor = ColorUtils.textureDiffuseColorsToRGB(defaultColor.getTextureDiffuseColors());
    }

    @Override
    public int getColor(final ItemStack stack) {
        return hasCustomColor(stack) ? DyeableLeatherItem.super.getColor(stack) : defaultColor;
    }
}
