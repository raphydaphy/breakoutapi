package org.liquidengine.legui.component.optional.textstate;

import java.util.function.BiConsumer;
import java.util.function.Predicate;

public class NumericTextState<T extends Number> extends TextState {
  private final T sampleValue;
  private T value;
  private Predicate<T> numericValidator;
  private BiConsumer<T, T> numberSetCallback;

  public NumericTextState(T value) {
    super();
    this.sampleValue = value;
    this.value = value;
    this.setValue(value);
  }

  public void setNumericValidator(Predicate<T> validator) {
    this.numericValidator = validator;
  }

  public Predicate<T> getNumericValidator() {
    return this.numericValidator;
  }

  @Override
  public NumericTextState<T> setText(String newText) {
    String oldText = this.getText();
    T oldValue = this.value;
    T newValue;

    try {
      newValue = this.tryParse(newText);
    } catch (NumberFormatException ex) {
      return this;
    }

    if (this.getValidator() != null && !this.getValidator().test(newText)) return this;
    if (this.numericValidator != null && !this.numericValidator.test(newValue)) return this;

    if (newText != null) this.text = newText;
    else this.text = "";

    this.value = newValue;

    this.caretPosition = this.startSelectionIndex = this.endSelectionIndex = 0;

    if (this.getTextSetCallback() != null) {
      this.getTextSetCallback().accept(oldText, newText);
    }

    if (this.numberSetCallback != null) {
      this.numberSetCallback.accept((T)oldValue, (T)newValue);
    }
    return this;
  }

  public NumericTextState<T> setValue(T value) {
    this.setText(value.toString());
    return this;
  }

  public T getValue() {
    return this.value;
  }

  public NumericTextState<T> setNumberSetCallback(BiConsumer<T, T> numberSetCallback) {
    this.numberSetCallback = numberSetCallback;
    return this;
  }

  public BiConsumer<T, T> getNumberSetCallback() {
    return this.numberSetCallback;
  }

  public T tryParse(String text) throws NumberFormatException {
    boolean zero = text == null || text.length() == 0 || text.equals("-");
    if (this.sampleValue instanceof Float) {
      if (zero) return (T)(Number)0f;
      return (T)(Number)Float.parseFloat(text);
    } else if (this.sampleValue instanceof Integer) {
      if (zero) return (T)(Number)0;
      return (T)(Number)Integer.parseInt(text);
    } else if (this.sampleValue instanceof Double) {
      if (zero) return (T)(Number)0d;
      return (T)(Number)Double.parseDouble(text);
    } else throw new UnsupportedOperationException("Unsupported numeric type: " + this.sampleValue.getClass());
  }
}
