package org.liquidengine.legui.component;

import org.joml.Vector2f;
import org.liquidengine.legui.style.Style;
import org.liquidengine.legui.style.color.ColorConstants;
import org.liquidengine.legui.theme.Themes;

public class FlexPanel extends Component {

  /**
   * Default constructor. Used to create component instance without any parameters. <p> Also if you want to make it easy to use with Json
   * marshaller/unmarshaller component should contain empty constructor.
   */
  public FlexPanel() {
    this.initialize();
  }

  /**
   * Constructor with size parameters.
   *
   * @param size size of component.
   */
  public FlexPanel(Vector2f size) {
    this(size.x, size.y);
  }

  /**
   * Constructor with position and size parameters.
   *
   * @param width width of component.
   * @param height height of component.
   */
  public FlexPanel(float width, float height) {
    super();
    this.setSize(width, height);
    this.getStyle().enableFlex(width, height);
    this.initialize();
  }

  private void initialize() {
    this.getStyle().setPosition(Style.PositionType.RELATIVE).setDisplay(Style.DisplayType.FLEX);
    this.setFocusable(false).setTabFocusable(false);
    Themes.getDefaultTheme().applyAll(this);
  }

}
