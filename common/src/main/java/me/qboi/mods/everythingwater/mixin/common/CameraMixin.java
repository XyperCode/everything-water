package me.qboi.mods.everythingwater.mixin.common;

import net.minecraft.client.Camera;
import net.minecraft.world.level.material.FogType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Camera.class)
public abstract class CameraMixin {
    @Inject(at = @At("HEAD"), method = "getFluidInCamera", cancellable = true)
    private void everythingWater$getFluidInCamera(CallbackInfoReturnable<FogType> cir) {
        cir.setReturnValue(FogType.WATER);
    }
}
