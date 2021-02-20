package com.raphydaphy.breakoutapi.mixin.client;

import com.raphydaphy.breakoutapi.BreakoutAPIClient;
import com.raphydaphy.breakoutapi.breakout.AbstractBreakout;
import com.raphydaphy.breakoutapi.breakout.Breakout;
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
		Breakout.checkError("before switch context");
		GLFW.glfwMakeContextCurrent(this.window.getHandle());
		Breakout.checkError("after switch context");
	}

	@Inject(at = @At(value = "INVOKE_STRING", args = "ldc=yield", target = "Lnet/minecraft/util/profiler/Profiler;swap(Ljava/lang/String;)V"), method = "render")
	private void afterRender(CallbackInfo info) {
		AbstractBreakout breakout = BreakoutAPIClient.CUR_BREAKOUT;
		if (breakout == null) return;

		MinecraftClient.getInstance().getProfiler().swap("breakout");

		Breakout.checkError("before breakout");
		breakout.setupRender();
		Breakout.checkError("after breakout");
	}
}
