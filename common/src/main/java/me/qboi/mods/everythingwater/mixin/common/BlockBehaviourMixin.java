package me.qboi.mods.everythingwater.mixin.common;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockBehaviour.class)
public class BlockBehaviourMixin {
    /**
     * Causes full water behaviour.
     */
    @Inject(method="getFluidState", at = @At("HEAD"), cancellable = true)
    public void getFluidState(BlockState state, CallbackInfoReturnable<FluidState> cir) {
        cir.setReturnValue(Fluids.WATER.defaultFluidState());
    }
}
