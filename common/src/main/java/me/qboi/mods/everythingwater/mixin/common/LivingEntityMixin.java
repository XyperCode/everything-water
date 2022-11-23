package me.qboi.mods.everythingwater.mixin.common;

import it.unimi.dsi.fastutil.objects.Object2DoubleMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Set;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
    @Inject(at = @At("HEAD"), method = "jumpInLiquid", cancellable = true)
    private void everythingWater$isEyeInFluid(TagKey<Fluid> tagKey, CallbackInfoReturnable<Boolean> cir) {
        if (tagKey == FluidTags.WATER) {
            cir.setReturnValue(true);
        }
    }

    @Inject(at = @At("HEAD"), method = "cabSisEyeInFluid", cancellable = true)
    private void everythingWater$canSwimInFluid(TagKey<Fluid> tagKey, CallbackInfoReturnable<Boolean> cir) {
        if (tagKey == FluidTags.WATER) {
            cir.setReturnValue(true);
        }
    }

    @Inject(at = @At("HEAD"), method = "isUnderWater", cancellable = true)
    private void everythingWater$isUnderWater(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(true);
    }

    @Inject(at = @At("RETURN"), method = "updateFluidOnEyes")
    private void everythingWater$updateFluidOnEyes(CallbackInfo ci) {
        fluidOnEyes.add(FluidTags.WATER);
        wasEyeInWater = true;
    }

    @Inject(at = @At(value = "RETURN"), method = "updateFluidHeightAndDoFluidPushing")
    private void everythingWater$updateFluidHeightAndDoFluidPushing(TagKey<Fluid> fluidTag, double motionScale, CallbackInfoReturnable<Boolean> cir) {
        fluidHeight.put(FluidTags.WATER, 1.0);
    }

    @Redirect(at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;clip(Lnet/minecraft/world/level/ClipContext;)Lnet/minecraft/world/phys/BlockHitResult;"), method = "move")
    private BlockHitResult everythingWater$move$invoke(Level instance, ClipContext clipContext) {
        return new BlockHitResult(position(), getDirection(), blockPosition(), true);
    }

    @Inject(at = @At(value = "RETURN"), method = "getFluidHeight", cancellable = true)
    private void everythingWater$getFluidHeight(TagKey<Fluid> fluidTag, CallbackInfoReturnable<Double> cir) {
        if (fluidTag == FluidTags.WATER) {
            cir.setReturnValue(1.0);
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


