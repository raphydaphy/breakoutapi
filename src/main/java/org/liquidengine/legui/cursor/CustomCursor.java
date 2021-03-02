package org.liquidengine.legui.cursor;

import net.minecraft.util.Identifier;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.lwjgl.glfw.GLFW;

public class CustomCursor extends Cursor {

  private final long imageReference;
  private final int xHot;
  private final int yHot;

  /**
   * @param imageReference the desired cursor image
   * @param xHot           the desired x-coordinate, in pixels, of the cursor hotspot
   * @param yHot           the desired y-coordinate, in pixels, of the cursor hotspot
   */
  public CustomCursor(Identifier id, long imageReference, int xHot, int yHot) {
    super(id);

    this.imageReference = imageReference;
    this.xHot = xHot;
    this.yHot = yHot;
  }

  @Override
  public long createHandle() {
    return GLFW.nglfwCreateCursor(this.getImageReference(), this.getxHot(), this.getyHot());
  }

  public long getImageReference() {
    return imageReference;
  }

  public int getxHot() {
    return xHot;
  }

  public int getyHot() {
    return yHot;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    CustomCursor that = (CustomCursor) o;
    return new EqualsBuilder().appendSuper(super.equals(o))
      .append(this.imageReference, that.imageReference)
      .append(this.xHot, that.xHot).append(this.yHot, that.yHot).isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37).appendSuper(super.hashCode())
      .append(this.imageReference).append(this.xHot).append(this.yHot).toHashCode();
  }
}
