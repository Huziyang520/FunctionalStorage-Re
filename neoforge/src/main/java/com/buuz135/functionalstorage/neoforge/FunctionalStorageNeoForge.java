package com.buuz135.functionalstorage.neoforge;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import com.buuz135.functionalstorage.FunctionalStorage;

/**
 * NeoForge entrypoint: only loader wiring lives here, everything else stays in common.
 */
@Mod(FunctionalStorage.MOD_ID)
public final class FunctionalStorageNeoForge {

    public FunctionalStorageNeoForge(IEventBus modBus) {
    }
}
