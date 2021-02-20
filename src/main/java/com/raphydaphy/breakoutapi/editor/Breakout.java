package com.raphydaphy.breakoutapi.editor;

import com.mojang.blaze3d.systems.RenderSystem;
import com.raphydaphy.breakoutapi.BreakoutAPI;
import com.raphydaphy.breakoutapi.BreakoutAPIClient;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL30;
import org.lwjgl.opengl.GL45;

import java.io.IOException;
import java.io.InputStream;

public class Breakout implements AutoCloseable {
  private BreakoutWindow window;
  private Framebuffer framebuffer;

  public Breakout() {
    this.window = new BreakoutWindow();

    MinecraftClient client = MinecraftClient.getInstance();

    try {
      InputStream inputStream = client.getResourcePackDownloader().getPack().open(ResourceType.CLIENT_RESOURCES, new Identifier(BreakoutAPI.MODID, "textures/icons/window_icon_16x16.png"));
      InputStream inputStream2 = client.getResourcePackDownloader().getPack().open(ResourceType.CLIENT_RESOURCES, new Identifier(BreakoutAPI.MODID, "textures/icons/window_icon_32x32.png"));
      this.window.setIcon(inputStream, inputStream2);
    } catch (IOException e) {
      BreakoutAPI.LOGGER.error("Failed to set breakout window icon!", e);
    }

    this.framebuffer = new Framebuffer(this.window.getFramebufferWidth(), this.window.getFramebufferHeight(), true, MinecraftClient.IS_SYSTEM_MAC);
    this.framebuffer.setClearColor(0.0F, 0.0F, 0.0F, 0.0F);

    RenderSystem.setupDefaultState(0, 0, this.window.getFramebufferWidth(), this.window.getFramebufferHeight());
  }

  private static Identifier LEAVES_TEXTURE = new Identifier("textures/block/azalea_leaves.png");
  private static Identifier FURNACE_GUI = new Identifier("textures/gui/container/furnace.png");

  public void render() {
    if (this.window.shouldClose()) {
      BreakoutAPI.LOGGER.info("Closing breakout window!");
      this.close();
      BreakoutAPIClient.CUR_BREAKOUT = null;
      return;
    }

    GLFW.glfwMakeContextCurrent(this.window.getHandle());

    GL30.glClear(GL30.GL_COLOR_BUFFER_BIT);

    this.framebuffer.beginWrite(true);

    GL30.glClearColor(1, 0, 1, 1);
    GL30.glClear(GL30.GL_COLOR_BUFFER_BIT);

    RenderSystem.matrixMode(GL30.GL_PROJECTION);
    RenderSystem.loadIdentity();
    RenderSystem.ortho(0, this.window.getFramebufferWidth(), this.window.getFramebufferHeight(), 0, 0, 1000);
    RenderSystem.matrixMode(GL30.GL_MODELVIEW);
    RenderSystem.loadIdentity();

    MinecraftClient client = MinecraftClient.getInstance();
    MatrixStack stack = new MatrixStack();

    RenderSystem.enableTexture();


    client.getTextureManager().bindTexture(FURNACE_GUI);
    DrawableHelper.drawTexture(stack, 10, 10, 0, 0, 0, 256, 256, 256, 256);

    client.getTextureManager().bindTexture(LEAVES_TEXTURE);
    DrawableHelper.drawTexture(stack, 50, 300, 0, 0, 0, 180, 300, 32, 32);

    //DrawableHelper.drawCenteredText(stack, MinecraftClient.getInstance().textRenderer, Text.of("Hello window world"), 10, 10, 0x000000);

    this.framebuffer.endWrite();
    this.framebuffer.draw(this.window.getFramebufferWidth(), this.window.getFramebufferHeight());

    GLFW.glfwSwapBuffers(this.window.getHandle());

    checkError("finish");
  }

  public static void checkError(String stage) {
    int error = GL45.glGetError();
    if (error != GL30.GL_NO_ERROR) {
      System.out.println("GL Error at stage " + stage + ": " + error);
    }
  }

  @Override
  public void close() {
    framebuffer.delete();
    GLFW.glfwDestroyWindow(this.window.getHandle());
  }
}
