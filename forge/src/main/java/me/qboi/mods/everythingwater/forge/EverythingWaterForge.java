package me.qboi.mods.everythingwater.forge;

import dev.architectury.platform.forge.EventBuses;
import me.qboi.mods.everythingwater.EverythingWater;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(EverythingWater.MOD_ID)
public class EverythingWaterForge {
    public EverythingWaterForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(EverythingWater.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        EverythingWater.init();
    }
}