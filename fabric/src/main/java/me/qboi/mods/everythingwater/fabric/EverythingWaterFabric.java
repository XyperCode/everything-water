package me.qboi.mods.everythingwater.fabric;

import me.qboi.mods.everythingwater.EverythingWater;
import net.fabricmc.api.ModInitializer;

public class EverythingWaterFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        EverythingWater.init();
    }
}