package com.raphydaphy.breakoutapi.demo;

import com.raphydaphy.breakoutapi.BreakoutAPI;
import org.liquidengine.legui.component.*;
import org.liquidengine.legui.component.optional.TextState;
import org.liquidengine.legui.component.optional.align.HorizontalAlign;
import org.liquidengine.legui.component.optional.align.VerticalAlign;
import org.liquidengine.legui.style.Background;
import org.liquidengine.legui.style.font.FontRegistry;

public class DemoGUI extends Panel {
  private Label title;

  public DemoGUI() {
    this(800, 600);
  }

  public DemoGUI(int width, int height) {
    super(0, 0, width, height);

    Label title = new Label("Demo GUI", 10, 10, 100, 30);
    {
      title.getStyle().setTextColor(0, 0.5f, 1, 1);
      title.getStyle().setFontSize(30f);
      title.getStyle().setFont(FontRegistry.ROBOTO_BOLD);
      this.add(title);
    }

    TextAreaField desc = new TextAreaField(10, 45, 400, 160);
    {
      desc.setTextState(new TextState("This GUI is powered by the LEGUI library. It's being rendered on the same OpenGL Context as Minecraft, so it has access to all the games resources."));
      desc.getStyle().setVerticalAlign(VerticalAlign.TOP);
      this.add(desc);
    }

    Widget radioDemo = new Widget("Demo Widget", 100, 200, 100, 100);
    {
      Label innerText = new Label("Here are some radio buttons for your enjoyment:", 10, 10, 100, 20);
      radioDemo.getContainer().add(innerText);

      RadioButtonGroup radioButtons = new RadioButtonGroup();
      RadioButton radio1 = new RadioButton("First Option", 10, 40, 100, 20);
      RadioButton radio2 = new RadioButton("Second Option", 10, 70, 100, 20);

      radio1.setChecked(true);
      radio2.setChecked(false);

      radio1.setRadioButtonGroup(radioButtons);
      radio2.setRadioButtonGroup(radioButtons);

      radioDemo.getContainer().add(radio1);
      radioDemo.getContainer().add(radio2);

      this.add(radioDemo);
    }

    Widget textInputDemo = new Widget("Text Input Demo", 200, 500, 300, 250);
    {
      textInputDemo.setResizable(false);

      Label innerText = new Label("Login Form", 0, 10, 300, 20);
      innerText.getStyle().setTextColor(1f, 0.5f, 0, 1f);
      innerText.getStyle().setHorizontalAlign(HorizontalAlign.CENTER);
      innerText.getStyle().setFont(FontRegistry.ROBOTO_BOLD);
      innerText.getStyle().setFontSize(30f);
      textInputDemo.getContainer().add(innerText);

      Label usernameLabel = new Label("Username", 10, 50, 280, 20);
      textInputDemo.getContainer().add(usernameLabel);

      TextInput usernameInput = new TextInput("Username", 10, 70, 280, 30);
      usernameInput.getStyle().setFontSize(20f);
      usernameInput.getStyle().setVerticalAlign(VerticalAlign.MIDDLE);
      textInputDemo.getContainer().add(usernameInput);

      Label passwordLabel = new Label("Password", 10, 110, 280, 20);
      textInputDemo.getContainer().add(passwordLabel);

      PasswordInput passwordInput = new PasswordInput("Password", 10, 130, 280, 30);
      passwordInput.getStyle().setFontSize(20f);
      passwordInput.getStyle().setVerticalAlign(VerticalAlign.MIDDLE);
      textInputDemo.getContainer().add(passwordInput);

      Label forgotPasswordLabel = new Label("Forgot password?", 10, 160, 280, 20);
      forgotPasswordLabel.getStyle().setTextColor(77 / 256f, 165 / 256f, 238 / 256f, 1f);
      forgotPasswordLabel.getHoveredStyle().setTextColor(137 / 256f, 195 / 256f, 242 / 256f, 1f);
      textInputDemo.getContainer().add(forgotPasswordLabel);

      Button loginButton = new Button("Login", 10, 190, 280, 30);
      loginButton.getStyle().setFontSize(20f);
      loginButton.getStyle().setFont(FontRegistry.ROBOTO_BOLD);
      loginButton.getStyle().setHorizontalAlign(HorizontalAlign.CENTER);
      loginButton.getStyle().setVerticalAlign(VerticalAlign.MIDDLE);
      loginButton.getStyle().setTextColor(1f, 1f, 1f, 1f);
      loginButton.getStyle().getBackground().setColor(19 / 256f, 92 / 256f, 236 / 256f, 1f);
      loginButton.getHoveredStyle().getBackground().setColor(11 / 256f, 61 / 256f, 161 / 256f, 1f);
      textInputDemo.getContainer().add(loginButton);

      this.add(textInputDemo);
    }
  }
}
