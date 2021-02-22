package com.raphydaphy.breakoutapi.breakout.window;

import org.liquidengine.legui.component.Frame;
import org.liquidengine.legui.system.context.Context;
import org.liquidengine.legui.system.handler.processor.SystemEventProcessor;
import org.liquidengine.legui.system.handler.processor.SystemEventProcessorImpl;
import org.liquidengine.legui.system.layout.LayoutManager;
import org.lwjgl.glfw.GLFW;

public abstract class GUIWindow extends BreakoutWindow {
  protected Frame frame;
  protected Context context;

  protected SystemEventProcessor systemEventProcessor;

  public GUIWindow(String title, int width, int height) {
    super(title, width, height);

    this.frame = new Frame(this.getWidth(), this.getHeight());
    this.createGuiElements(this.getWidth(), this.getHeight());

    this.context = new Context(this.getHandle());

    this.systemEventProcessor = new SystemEventProcessorImpl();
    SystemEventProcessor.addDefaultCallbacks(this.keeper, this.systemEventProcessor);
  }

  @Override
  public void update() {
    this.context.updateGlfwWindow();
  }

  @Override
  protected void onWindowSizeChanged(long window, int width, int height) {
    super.onWindowSizeChanged(window, width, height);
    if (window == this.getHandle()) {
      this.frame.setSize(width, height);
    }
  }

  protected abstract void createGuiElements(int width, int height);

  public void updateLayout() {
    LayoutManager.getInstance().layout(this.frame);
  }

  public void processSystemEvents() {
    this.systemEventProcessor.processEvents(this.frame, this.context);
  }

  public Frame getFrame() {
    return this.frame;
  }

  public Context getContext() {
    return this.context;
  }
}
