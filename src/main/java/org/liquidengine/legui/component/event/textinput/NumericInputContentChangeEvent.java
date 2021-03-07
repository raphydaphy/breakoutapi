package org.liquidengine.legui.component.event.textinput;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.liquidengine.legui.component.Frame;
import org.liquidengine.legui.component.NumericInput;
import org.liquidengine.legui.event.Event;
import org.liquidengine.legui.system.context.Context;

public class NumericInputContentChangeEvent<S extends Number, T extends NumericInput<S>> extends Event<T> {

  private final S oldValue;
  private final S newValue;

  public NumericInputContentChangeEvent(T component, Context context, Frame frame, S oldValue, S newValue) {
    super(component, context, frame);
    this.oldValue = oldValue;
    this.newValue = newValue;
  }

  /**
   * Returns old value.
   *
   * @return old value.
   */
  public S getOldValue() {
    return oldValue;
  }

  /**
   * Returns new value.
   *
   * @return new value.
   */
  public S getNewValue() {
    return newValue;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
      .append("oldValue", oldValue.toString())
      .append("newValue", newValue.toString())
      .toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;

    if (o == null || getClass() != o.getClass()) return false;

    NumericInputContentChangeEvent<?, ?> that = (NumericInputContentChangeEvent<?, ?>) o;

    return new EqualsBuilder()
      .appendSuper(super.equals(o))
      .append(oldValue, that.oldValue)
      .append(newValue, that.newValue)
      .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
      .appendSuper(super.hashCode())
      .append(oldValue)
      .append(newValue)
      .toHashCode();
  }
}