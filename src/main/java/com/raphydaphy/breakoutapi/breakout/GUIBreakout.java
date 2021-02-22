package com.raphydaphy.breakoutapi.breakout;

import com.mojang.blaze3d.platform.GlStateManager;
import com.raphydaphy.breakoutapi.breakout.window.GUIWindow;
import org.liquidengine.legui.animation.AnimatorProvider;
import org.liquidengine.legui.listener.processor.EventProcessorProvider;
import org.liquidengine.legui.system.renderer.Renderer;
import org.liquidengine.legui.system.renderer.nvg.NvgRenderer;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL30;

public class GUIBreakout extends AbstractBreakout {
  private Renderer renderer;

  public GUIBreakout(GUIWindow window) {
    super(window);

    this.renderer = new NvgRenderer();
    renderer.initialize();
  }

  @Override
  public void render() {
    GUIWindow window = (GUIWindow)this.window;

    /*
    GL30.glClearColor(1, 1, 1, 1);
    GL30.glViewport(0, 0, this.window.getFramebufferWidth(), this.window.getFramebufferHeight());
    GL30.glClear(GL30.GL_COLOR_BUFFER_BIT | GL30.GL_STENCIL_BUFFER_BIT);
    */

    window.updateLayout();
    this.renderer.render(window.getFrame(), window.getContext());
  }

  @Override
  public void postRender() {
    GUIWindow window = (GUIWindow)this.window;

    AnimatorProvider.getAnimator().runAnimations();

    window.processSystemEvents();
    EventProcessorProvider.getInstance().processEvents();
  }
  public void destroy() {
    this.renderer.destroy();
    super.destroy();
  }
}
