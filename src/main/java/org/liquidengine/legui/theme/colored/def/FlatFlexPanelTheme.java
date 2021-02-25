package org.liquidengine.legui.theme.colored.def;

import org.liquidengine.legui.component.Button;
import org.liquidengine.legui.component.FlexPanel;
import org.liquidengine.legui.style.color.ColorConstants;
import org.liquidengine.legui.theme.colored.FlatColoredTheme;


/**
 * Dark Button Theme for all buttons. Used to make button dark.
 *
 * @param <T> {@link Button} subclasses.
 */
public class FlatFlexPanelTheme<T extends FlexPanel> extends FlatComponentTheme<T> {

  /**
   * Default constructor. Settings should be specified before using this theme.
   */
  public FlatFlexPanelTheme() {
  }

  public FlatFlexPanelTheme(FlatColoredTheme.FlatColoredThemeSettings settings) {
    super(settings);
  }

  /**
   * Used to apply theme only for component and not apply for child components.
   *
   * @param component component to apply theme.
   */
  @Override
  public void apply(T component) {
    super.apply(component);
    component.getStyle().getBackground().setColor(ColorConstants.transparent());
    component.getStyle().setBorder(null).setShadow(null);
  }
}

