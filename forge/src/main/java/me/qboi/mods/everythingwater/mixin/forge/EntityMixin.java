package me.qboi.mods.everythingwater.mixin.forge;

import it.unimi.dsi.fastutil.objects.Object2DoubleMap;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.fluids.FluidType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class EntityMixin {
    @Shadow private FluidType forgeFluidTypeOnEyes;

    @Shadow protected Object2DoubleMap<FluidType> forgeFluidTypeHeight;


    @Inject(at = @At("RETURN"), method = "updateFluidOnEyes")
    private void everythingWater$updateFluidOnEyes(CallbackInfo ci) {
        forgeFluidTypeOnEyes = Fluids.WATER.getFluidType();
    }

    @Inject(at = @At(value = "RETURN"), method = "updateFluidHeightAndDoFluidPushing")
    private void everythingWater$updateFluidHeightAndDoFluidPushing(TagKey<Fluid> fluidTag, double motionScale, CallbackInfoReturnable<Boolean> cir) {
        forgeFluidTypeHeight.put(Fluids.WATER.getFluidType(), 1.0);
        if (fluidTag == FluidTags.WATER) {
            cir.setReturnValue(true);
        }
    }

    @Inject(at = @At(value = "RETURN"), method = "getFluidTypeHeight", cancellable = true, remap = false)
    private void everythingWater$getFluidTypeHeight(FluidType fluidType, CallbackInfoReturnable<Double> cir) {
        if (fluidType == Fluids.WATER.getFluidType()) {
            cir.setReturnValue(1.0);
        }
    }

}
