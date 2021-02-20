package com.raphydaphy.breakoutapi.editor;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL30;
import org.lwjgl.opengl.GL45;

public class Breakout {
  private BreakoutWindow window;
  private Framebuffer framebuffer;

  public Breakout() {
    checkError("before start");
    this.window = new BreakoutWindow();
    checkError("window created");
    this.framebuffer = new Framebuffer(this.window.getFramebufferWidth(), this.window.getFramebufferHeight(), true, MinecraftClient.IS_SYSTEM_MAC);
    checkError("framebuffer created");
    this.framebuffer.setClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    checkError("framebuffer cleared");
    RenderSystem.setupDefaultState(0, 0, this.window.getFramebufferWidth(), this.window.getFramebufferHeight());
    checkError("finish setup");
  }

  private static Identifier LEAVES_TEXTURE = new Identifier("textures/block/azalea_leaves.png");
  private static Identifier FURNACE_GUI = new Identifier("textures/gui/container/furnace.png");

  public void render() {
    if (window.shouldClose()) return;
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
}
