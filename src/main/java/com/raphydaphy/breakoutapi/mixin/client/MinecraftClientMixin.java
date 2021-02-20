package com.raphydaphy.breakoutapi.mixin.client;

import com.raphydaphy.breakoutapi.BreakoutAPIClient;
import com.raphydaphy.breakoutapi.editor.Breakout;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.Window;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
	@Shadow @Final
	private Window window;

	@Inject(at = @At("HEAD"), method = "render(Z)V")
	private void beforeRender(CallbackInfo info) {
		GLFW.glfwMakeContextCurrent(this.window.getHandle());
	}

	@Inject(at = @At("RETURN"), method="render(Z)V")
	private void afterRender(CallbackInfo info) {
		Breakout breakout = BreakoutAPIClient.CUR_BREAKOUT;
		if (breakout == null) return;

		breakout.render();
	}
}
