package me.qboi.mods.everythingwater.mixin.common;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Level.class)
public class LevelMixin {
    @Inject(method="getFluidState", at = @At("HEAD"), cancellable = true)
    public void getFluidState(BlockPos pos, CallbackInfoReturnable<FluidState> cir) {
        cir.setReturnValue(Fluids.WATER.defaultFluidState());
    }
}
