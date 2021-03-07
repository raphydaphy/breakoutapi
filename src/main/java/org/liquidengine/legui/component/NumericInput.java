package org.liquidengine.legui.component;

import org.liquidengine.legui.component.optional.textstate.NumericTextState;

public class NumericInput<T extends Number> extends TextInput {
  public NumericInput() {
    super(Float.toString(0));
  }

  public NumericInput(T value) {
    super(value.toString());
    this.textState = new NumericTextState<>(value);
  }
}
