package com.raphydaphy.breakoutapi.mixin.client;

import com.mojang.blaze3d.platform.GlStateManager;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(GlStateManager.class)
public class GlStateManagerMixin {
//  @Unique private static BreakoutGlState glState;
//
//  @Redirect(method = {"disableAlphaTest", "enableAlphaTest"}, at = @At(value = "FIELD", target = "Lcom/mojang/blaze3d/platform/GlStateManager$AlphaTestState;capState:Lcom/mojang/blaze3d/platform/GlStateManager$CapabilityTracker;"))
//  private static GlStateManager.CapabilityTracker redirectAlphaTest(GlStateManager.AlphaTestState alpha) {
//    return ;
//  }
}
