package org.liquidengine.legui.component;

import com.raphydaphy.breakoutapi.BreakoutAPI;
import org.liquidengine.legui.component.event.label.LabelWidthChangeEvent;

public class FlexLabel extends Label {
  private boolean autoHeight;

  public FlexLabel() {
    this(Label.DEFAULT_LABEL_TEXT);
  }

  public FlexLabel(String text) {
    this(text, true);
  }

  public FlexLabel(String text, boolean autoHeight) {
    super(text);

    this.autoHeight = autoHeight;
    this.getStyle().enableFlex(1, 1);

    this.getListenerMap().addListener(LabelWidthChangeEvent.class, this::onWidthChanged);
  }

  private void onWidthChanged(LabelWidthChangeEvent e) {
    this.getStyle().setWidths(e.getWidth());
    if (this.autoHeight) this.getStyle().setHeights(this.getStyle().getFontSize());
  }

  public FlexLabel setAutoHeight(boolean autoHeight) {
    this.autoHeight = autoHeight;
    return this;
  }

  public boolean isAutoHeightEnabled() {
    return this.autoHeight;
  }
}
