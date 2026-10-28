// Functional Storage Jade Armory Data Provider

package com.buuz135.functionalstorage.compat.jade;

import com.buuz135.functionalstorage.FunctionalStorage;
import com.buuz135.functionalstorage.block.tile.ArmoryCabinetTile;
import com.buuz135.functionalstorage.util.Utils;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.Identifier;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IServerDataProvider;

public enum ArmoryDataProvider implements IServerDataProvider<BlockAccessor> {
    INSTANCE;

    private static final Identifier ID = Utils.resourceLocation(FunctionalStorage.MOD_ID, "armory");

    @Override
    public void appendServerData(CompoundTag data, BlockAccessor blockAccessor) {
        if (blockAccessor.getBlockEntity() instanceof ArmoryCabinetTile armory) {
            long count = armory.handler.stackList.stream().filter(stack -> !stack.isEmpty()).count();
            data.putInt(getUid().toLanguageKey(), (int) count);
        }
    }

    @Override
    public Identifier getUid() {
        return ID;
    }
}
