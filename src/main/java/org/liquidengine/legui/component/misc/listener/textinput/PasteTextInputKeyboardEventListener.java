package org.liquidengine.legui.component.misc.listener.textinput;

import org.liquidengine.legui.component.NumericInput;
import org.liquidengine.legui.component.TextInput;
import org.liquidengine.legui.component.event.textinput.NumericInputContentChangeEvent;
import org.liquidengine.legui.component.event.textinput.TextInputContentChangeEvent;
import org.liquidengine.legui.component.misc.listener.text.PasteTextEventListener;
import org.liquidengine.legui.component.optional.textstate.NumericTextState;
import org.liquidengine.legui.event.KeyEvent;
import org.liquidengine.legui.event.KeyboardEvent;
import org.liquidengine.legui.listener.EventListener;
import org.liquidengine.legui.listener.processor.EventProcessorProvider;

/**
 * Key event listener. Used to provide some text operations by keyboard.
 */
public class PasteTextInputKeyboardEventListener extends PasteTextEventListener
  implements EventListener<KeyboardEvent> {

  /**
   * Used to handle {@link KeyEvent}.
   *
   * @param event event to handle.
   */
  @Override
  public void process(KeyboardEvent event) {
    processPaste(event, (oldText, newText) -> {
      EventProcessorProvider.getInstance().pushEvent(new TextInputContentChangeEvent<>(
        (TextInput) event.getTargetComponent(),
        event.getContext(), event.getFrame(), oldText, newText
      ));

      if (event.getTargetComponent() instanceof NumericInput) {
        NumericInput<?> numericInput = (NumericInput<?>) event.getTargetComponent();
        NumericTextState<?> numericTextState = numericInput.getTextState();
        EventProcessorProvider.getInstance().pushEvent(new NumericInputContentChangeEvent(
          numericInput, event.getContext(), event.getFrame(),
          numericTextState.tryParse(oldText), numericTextState.getValue()
        ));
      }
    });

  }
}
