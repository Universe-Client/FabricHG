package de.royzer.fabrichg.mixins.entity.ai.goal;

import de.royzer.fabrichg.game.GamePhaseManager;
import de.royzer.fabrichg.game.phase.PhaseType;
import net.minecraft.world.entity.ai.goal.FollowMobGoal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FollowMobGoal.class)
public class FollowTargetGoalMixin {
    @Inject(
            method = "canUse",
            at = @At("HEAD"),
            cancellable = true
    )
    public void blockTarget(CallbackInfoReturnable<Boolean> cir) {
        if (GamePhaseManager.INSTANCE.getCurrentPhaseType().equals(PhaseType.LOBBY) || GamePhaseManager.INSTANCE.getCurrentPhaseType().equals(PhaseType.INVINCIBILITY)) {
            cir.setReturnValue(false);
        }
    }
}
