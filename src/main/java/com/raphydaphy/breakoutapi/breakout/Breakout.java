package com.raphydaphy.breakoutapi.breakout;

import com.mojang.blaze3d.systems.RenderSystem;
import com.raphydaphy.breakoutapi.breakout.window.BreakoutWindow;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL30;

import static org.lwjgl.glfw.GLFW.glfwGetWindowSize;

public abstract class Breakout extends AbstractBreakout {

  public Breakout(Identifier identifier, BreakoutWindow window) {
    super(identifier, window);
  }

  @Override
  public void render() {
    RenderSystem.enableTexture();
    RenderSystem.enableCull();

    RenderSystem.clearColor(1, 1, 1, 1);
    RenderSystem.clear(GL30.GL_COLOR_BUFFER_BIT | GL30.GL_DEPTH_BUFFER_BIT, MinecraftClient.IS_SYSTEM_MAC);

    RenderSystem.matrixMode(GL30.GL_PROJECTION);
    RenderSystem.loadIdentity();
    RenderSystem.ortho(0, this.window.getFramebufferWidth(), this.window.getFramebufferHeight(), 0, 0, 1000);
    RenderSystem.matrixMode(GL30.GL_MODELVIEW);
    RenderSystem.loadIdentity();
  }
}
