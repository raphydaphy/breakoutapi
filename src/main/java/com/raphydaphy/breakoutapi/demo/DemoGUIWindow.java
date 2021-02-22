package com.raphydaphy.breakoutapi.demo;

import com.raphydaphy.breakoutapi.breakout.window.GUIWindow;
import org.liquidengine.legui.component.Component;
import org.liquidengine.legui.demo.ExampleGui;
import org.liquidengine.legui.event.WindowSizeEvent;
import org.liquidengine.legui.listener.WindowSizeEventListener;
import org.liquidengine.legui.style.Style;
import org.liquidengine.legui.style.color.ColorConstants;
import org.liquidengine.legui.style.font.FontRegistry;
import org.liquidengine.legui.theme.Themes;
import org.liquidengine.legui.theme.colored.FlatColoredTheme;

import static org.liquidengine.legui.style.color.ColorUtil.fromInt;

public class DemoGUIWindow extends GUIWindow {
  private DemoGUI gui;

  public DemoGUIWindow(String title, int width, int height) {
    super(title, width, height);

    Themes.setDefaultTheme(new FlatColoredTheme(
      fromInt(245, 245, 245, 1), // backgroundColor
      fromInt(176, 190, 197, 1), // borderColor
      fromInt(176, 190, 197, 1), // sliderColor
      fromInt(100, 181, 246, 1), // strokeColor
      fromInt(165, 214, 167, 1), // allowColor
      fromInt(239, 154, 154, 1), // denyColor
      ColorConstants.transparent(), // shadowColor
      ColorConstants.darkGray(), // text color
      FontRegistry.getDefaultFont(), // font
      16f //font size
    ));
  }

  @Override
  protected void createGuiElements(int width, int height) {
    this.gui = new DemoGUI(width, height);
    this.gui.setFocusable(false);
    this.gui.getListenerMap().addListener(WindowSizeEvent.class, (WindowSizeEventListener) event -> gui.setSize(event.getWidth(), event.getHeight()));
    this.frame.getContainer().add(this.gui);

    /*
    Component frameContainer = frame.getContainer();
    frameContainer.getStyle().setDisplay(Style.DisplayType.FLEX);
    frameContainer.getStyle().getBackground().setColor(ColorConstants.lightGray());
    */
  }

  @Override
  public void update() {
    super.update();
  }
}
