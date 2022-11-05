package me.qboi.mods.everythingwater;

import dev.architectury.event.events.common.TickEvent;
import dev.architectury.utils.Env;
import dev.architectury.utils.EnvExecutor;
import me.qboi.mods.everythingwater.client.ClientEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;

public class EverythingWater {
    public static final String MOD_ID = "everythingwater";

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static void init() {
        EnvExecutor.runInEnv(Env.CLIENT, () -> ClientEvents::new);

        TickEvent.SERVER_LEVEL_POST.register(EverythingWater::onLevelTickPost);
    }

    private static void onLevelTickPost(ServerLevel serverLevel) {
        serverLevel.setDayTime(18000);
    }

    public static ResourceLocation res(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}