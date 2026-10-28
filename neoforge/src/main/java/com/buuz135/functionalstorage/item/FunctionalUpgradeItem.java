// Functional Storage Functional Upgrade Item

package com.buuz135.functionalstorage.item;

import com.buuz135.functionalstorage.item.component.DelegateToItemBehavior;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

@Deprecated(forRemoval = true)
public class FunctionalUpgradeItem extends FSItem {

    public FunctionalUpgradeItem(Properties properties) {
        super(properties.component(FSAttachments.FUNCTIONAL_BEHAVIOR, DelegateToItemBehavior.INSTANCE));
    }

    public void work(Level level, BlockPos pos, ItemStack upgradeStack) {

    }
}
