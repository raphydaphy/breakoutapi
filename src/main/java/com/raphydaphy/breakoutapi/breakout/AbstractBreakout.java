package com.raphydaphy.breakoutapi.breakout;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.raphydaphy.breakoutapi.BreakoutAPI;
import com.raphydaphy.breakoutapi.BreakoutAPIClient;
import com.raphydaphy.breakoutapi.breakout.window.BreakoutWindow;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL30;
import org.lwjgl.opengl.GL45;

public abstract class AbstractBreakout {
  private Identifier identifier;
  protected BreakoutWindow window;
  protected Framebuffer framebuffer;

  public AbstractBreakout(Identifier identifier, BreakoutWindow window) {
    this.identifier = identifier;
    this.window = window;
    this.window.setIcon(new Identifier(BreakoutAPI.MODID, "textures/icons/window_icon_16x16.png"), new Identifier(BreakoutAPI.MODID, "textures/icons/window_icon_32x32.png"));

    this.framebuffer = new Framebuffer(this.window.getFramebufferWidth(), this.window.getFramebufferHeight(), true, MinecraftClient.IS_SYSTEM_MAC);
    this.framebuffer.setClearColor(0.0F, 0.0F, 0.0F, 0.0F);

    RenderSystem.setupDefaultState(0, 0, this.window.getFramebufferWidth(), this.window.getFramebufferHeight());

    this.onResolutionChanged(this.window.getFramebufferWidth(), this.window.getFramebufferHeight());
    this.window.keeper.getChainResolutionChangedCallback().add(this::onResolutionChanged);
  }

  public abstract void render();
  protected void postRender() {}

  public void setupRender() {
    if (this.window.shouldClose()) return;

    GLFW.glfwMakeContextCurrent(this.window.getHandle());

    RenderSystem.pushMatrix();
    RenderSystem.clear(GL30.GL_COLOR_BUFFER_BIT | GL30.GL_DEPTH_BUFFER_BIT, MinecraftClient.IS_SYSTEM_MAC);

    this.framebuffer.beginWrite(true);

    RenderSystem.viewport(0, 0, this.window.getFramebufferWidth(), this.window.getFramebufferHeight());

    this.window.update();
    this.render();

    this.framebuffer.endWrite();
    RenderSystem.popMatrix();

    RenderSystem.pushMatrix();
    this.framebuffer.draw(this.window.getFramebufferWidth(), this.window.getFramebufferHeight());
    RenderSystem.popMatrix();

    this.window.swapBuffers();

    this.postRender();

  }


  public static void checkError(String stage) {
    int error = GL45.glGetError();
    if (error != GL30.GL_NO_ERROR) {
      System.out.println("GL Error at stage " + stage + ": " + error);
    }
  }

  public void destroy() {
    framebuffer.delete();
    GLFW.glfwDestroyWindow(this.window.getHandle());
  }

  public void onResolutionChanged(int width, int height) {
    long existingContext = GLFW.glfwGetCurrentContext();
    GLFW.glfwMakeContextCurrent(this.window.getHandle());
    this.framebuffer.resize(width, height, MinecraftClient.IS_SYSTEM_MAC);
    GLFW.glfwMakeContextCurrent(existingContext);
  }

  public BreakoutWindow getWindow() {
     return this.window;
  }
}
