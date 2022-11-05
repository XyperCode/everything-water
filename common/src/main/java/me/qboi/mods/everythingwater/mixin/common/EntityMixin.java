package me.qboi.mods.everythingwater.mixin.common;

import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.material.Fluid;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public abstract class EntityMixin {
    @Inject(at = @At("HEAD"), method = "isEyeInFluid", cancellable = true)
    private void everythingWater$isEyeInFluid(TagKey<Fluid> tagKey, CallbackInfoReturnable<Boolean> cir) {
        if (tagKey == FluidTags.WATER) {
            cir.setReturnValue(true);
        }
    }

    @Inject(at = @At("HEAD"), method = "isInWater", cancellable = true)
    private void everythingWater$isInWater(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(true);
    }

    @Inject(at = @At("HEAD"), method = "isInWaterOrBubble", cancellable = true)
    private void everythingWater$isInWaterOrBubble(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(true);
    }

    @Inject(at = @At("HEAD"), method = "isInWaterOrRain", cancellable = true)
    private void everythingWater$isInWaterOrRain(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(true);
    }

    @Inject(at = @At("HEAD"), method = "isInWaterRainOrBubble", cancellable = true)
    private void everythingWater$isInWaterRainOrRain(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(true);
    }
}


