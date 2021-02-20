package com.raphydaphy.breakoutapi.editor;

import net.minecraft.client.MinecraftClient;
import org.lwjgl.glfw.GLFW;

public class BreakoutWindow implements AutoCloseable {
  private final long handle;
  private int width = 300;
  private int height = 720;
  private int framebufferWidth;
  private int framebufferHeight;

  public BreakoutWindow() {
    this.handle = GLFW.glfwCreateWindow(this.width, this.height, "Breakout Demo", 0L, MinecraftClient.getInstance().getWindow().getHandle());

    GLFW.glfwMakeContextCurrent(this.handle);

    this.updateFramebufferSize();

    GLFW.glfwSetWindowSizeCallback(this.handle, this::onWindowSizeChanged);
    GLFW.glfwSetFramebufferSizeCallback(this.handle, this::onFramebufferSizeChanged);
  }

  private void onWindowSizeChanged(long window, int width, int height) {
    if (window == this.handle) {
      this.width = width;
      this.height = height;
    }
  }

  private void onFramebufferSizeChanged(long window, int width, int height) {
    if (window == this.handle) {
      int i = this.getFramebufferWidth();
      int j = this.getFramebufferHeight();
      if (width != 0 && height != 0) {
        this.framebufferWidth = width;
        this.framebufferHeight = height;
        if (this.getFramebufferWidth() != i || this.getFramebufferHeight() != j) {
          System.out.println("Breakout size changed from " + this.framebufferWidth + "x" + this.framebufferHeight + " to " + width + "x" + height);
        }
      }
    }
  }

  private void updateFramebufferSize() {
    int[] framebufferWidth = new int[1];
    int[] framebufferHeight = new int[1];
    GLFW.glfwGetFramebufferSize(this.handle, framebufferWidth, framebufferHeight);
    this.framebufferWidth = framebufferWidth[0];
    this.framebufferHeight = framebufferHeight[0];
  }

  public long getHandle() {
    return this.handle;
  }

  public int getWidth() {
    return this.width;
  }

  public int getHeight() {
    return this.height;
  }

  public int getFramebufferWidth() {
    return this.framebufferWidth;
  }

  public int getFramebufferHeight() {
    return this.framebufferHeight;
  }

  public boolean shouldClose() {
    return GLFW.glfwWindowShouldClose(handle);
  }

  @Override
  public void close() {
    GLFW.glfwDestroyWindow(this.handle);
  }
}
