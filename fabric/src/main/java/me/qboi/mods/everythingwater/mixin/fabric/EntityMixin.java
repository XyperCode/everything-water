package me.qboi.mods.everythingwater.mixin.fabric;

import it.unimi.dsi.fastutil.objects.Object2DoubleMap;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class EntityMixin {
    @Shadow protected Object2DoubleMap<TagKey<Fluid>> fluidHeight;

    @Redirect(at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;getFluidState(Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/material/FluidState;"), method = "updateSwimming")
    private FluidState everythingWater$updateSwimming$invoke(Level instance, BlockPos pos) {
        return Fluids.WATER.defaultFluidState();
    }

    @Inject(at = @At(value = "RETURN"), method = "updateFluidHeightAndDoFluidPushing", cancellable = true)
    private void everythingWater$updateFluidHeightAndDoFluidPushing(TagKey<Fluid> fluidTag, double motionScale, CallbackInfoReturnable<Boolean> cir) {
        this.fluidHeight.put(FluidTags.WATER, 1.0);
        if (fluidTag == FluidTags.WATER) {
            cir.setReturnValue(true);
        }
    }
}
