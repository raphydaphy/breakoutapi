package org.liquidengine.legui.component;

import org.liquidengine.legui.component.event.textinput.NumericInputContentChangeEvent;
import org.liquidengine.legui.component.event.textinput.TextInputContentChangeEvent;
import org.liquidengine.legui.component.optional.textstate.NumericTextState;
import org.liquidengine.legui.listener.EventListener;

import java.util.List;

public class NumericInput<T extends Number> extends TextInput {
  public NumericInput() {
    super(Float.toString(0));
  }

  public NumericInput(T value) {
    super(value.toString());
    this.textState = new NumericTextState<>(value);
  }

  @Override
  public NumericTextState<T> getTextState() {
    return (NumericTextState<T>) this.textState;
  }

  public void addValueChangeListener(EventListener<NumericInputContentChangeEvent<T, NumericInput<T>>> eventListener) {
    this.getListenerMap().addExtensibleListener(NumericInputContentChangeEvent.class, eventListener);
  }
}
