package org.liquidengine.legui.cursor;

import net.minecraft.util.Identifier;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.liquidengine.legui.Legui;
import org.lwjgl.glfw.GLFW;

public class StandardCursor extends Cursor {
  public static final StandardCursor ARROW = new StandardCursor("arrow", GLFW.GLFW_ARROW_CURSOR);
  public static final StandardCursor H_RESIZE = new StandardCursor("horizontal_resize", GLFW.GLFW_HRESIZE_CURSOR);
  public static final StandardCursor V_RESIZE = new StandardCursor("vertical_resize", GLFW.GLFW_VRESIZE_CURSOR);
  public static final StandardCursor CROSSHAIR = new StandardCursor("crosshair", GLFW.GLFW_CROSSHAIR_CURSOR);
  public static final StandardCursor HAND = new StandardCursor("hand", GLFW.GLFW_HAND_CURSOR);
  public static final StandardCursor IBEAM = new StandardCursor("typing_pointer", GLFW.GLFW_IBEAM_CURSOR);

  private int type;

  private StandardCursor(String name, int type) {
    super(new Identifier(Legui.ID, name));
    this.type = type;
  }

  @Override
  public long createHandle() {
    return GLFW.glfwCreateStandardCursor(this.type);
  }

  public int getType() {
    return this.type;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    StandardCursor that = (StandardCursor) o;
    return new EqualsBuilder().appendSuper(super.equals(o)).append(this.type, that.type).isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37).appendSuper(super.hashCode()).append(this.type).toHashCode();
  }
}
