package net.tearpelato.falldrop_backport.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import net.tearpelato.falldrop_backport.block.custom.core.AbstractBedBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @Shadow
    public abstract Optional<BlockPos> getSleepingPos();

    @Inject(method = "checkBedExists", at = @At(value = "RETURN"), cancellable = true)
    private void checkBedExistsStraw(CallbackInfoReturnable<Boolean> cir) {
        if (!cir.getReturnValue()) {
            boolean hasStrawBed = this.getSleepingPos()
                    .map(bedPosition -> LivingEntity.class.cast(this).level().getBlockState(bedPosition).getBlock() instanceof AbstractBedBlock)
                    .orElse(false);
            if (hasStrawBed) cir.setReturnValue(true);
        }
    }

    @Inject(method = "getBedOrientation", at = @At(value = "TAIL"), cancellable = true)
    private void getBedOrientationStraw(CallbackInfoReturnable<Direction> cir, @Local(name = "bedPos") BlockPos bedPos) {
        if (cir.getReturnValue() == null) {
            Direction facing = bedPos != null ? AbstractBedBlock.getBedOrientation(LivingEntity.class.cast(this).level(), bedPos) : null;
            if (facing != null) cir.setReturnValue(facing);
        }
    }
}