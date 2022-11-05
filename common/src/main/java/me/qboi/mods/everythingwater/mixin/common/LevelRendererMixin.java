package me.qboi.mods.everythingwater.mixin.common;

import me.qboi.mods.everythingwater.Resources;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LevelRenderer.class)
public class LevelRendererMixin {
    @Redirect(at = @At(value = "FIELD", target = "Lnet/minecraft/client/renderer/LevelRenderer;MOON_LOCATION:Lnet/minecraft/resources/ResourceLocation;"), method = "renderSky")
    private ResourceLocation everythingWater$renderSky$getField$MOON_LOCATION() {
        return Resources.MOON_REDIRECT;
    }
}
