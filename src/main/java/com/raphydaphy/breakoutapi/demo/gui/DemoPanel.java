package com.raphydaphy.breakoutapi.demo.gui;

import net.minecraft.util.Identifier;
import org.liquidengine.legui.component.*;
import org.liquidengine.legui.component.optional.TextState;
import org.liquidengine.legui.component.optional.align.HorizontalAlign;
import org.liquidengine.legui.component.optional.align.VerticalAlign;
import org.liquidengine.legui.event.MouseClickEvent;
import org.liquidengine.legui.image.loader.ImageLoader;
import org.liquidengine.legui.style.Style;
import org.liquidengine.legui.style.flex.FlexStyle;
import org.liquidengine.legui.style.font.FontRegistry;
import org.liquidengine.legui.system.context.Context;
import org.liquidengine.legui.system.renderer.nvg.NvgRenderer;
import org.lwjgl.glfw.GLFW;

public class DemoPanel extends Panel {

  public DemoPanel(int width, int height) {
    super(0, 0, width, height);

    Label title = new Label("Demo GUI", 10, 10, 100, 30);
    {
      title.getStyle().setTextColor(0, 0.5f, 1, 1).setFontSize(30f).setFont(FontRegistry.ROBOTO_BOLD);
      this.add(title);
    }

    TextArea desc = new TextArea(10, 45, 400, 160);
    {
      desc.setTextState(new TextState(
        "This GUI is powered by the LEGUI library. It's being rendered with the\n" +
          "same OpenGL Context as the Minecraft game window, so it has access\n" +
          "to all the games resources and data.\n\n" +
          "This window can also be used for any number of other purposes. It is\n" +
          "fully integrated into the game, so a portion of the Minecraft world can\n" +
          "be rendered here, or even a map, or a preview of the players inventory."
      ));

      desc.setHorizontalScrollBarVisible(false).setVerticalScrollBarVisible(false);
      desc.getStyle().setVerticalAlign(VerticalAlign.TOP).setBorderRadius(0f);
      this.add(desc);
    }

    Widget radioDemo = new Widget("Demo Widget", 100, 200, 100, 100);
    {
      Label innerText = new Label("Here are some radio buttons for your enjoyment:", 10, 10, 100, 20);
      radioDemo.getContainer().add(innerText);

      RadioButtonGroup radioButtons = new RadioButtonGroup();
      RadioButton radio1 = new RadioButton("First Option", 10, 40, 100, 20).setChecked(true);
      RadioButton radio2 = new RadioButton("Second Option", 10, 70, 100, 20);

      radio1.setRadioButtonGroup(radioButtons);
      radio2.setRadioButtonGroup(radioButtons);

      radioDemo.getContainer().add(radio1).add(radio2);
      this.add(radioDemo);
    }

    Widget textInputDemo = new Widget("Text Input Demo", 200, 500, 300, 250);
    {
      textInputDemo.setResizable(false);

      Label innerText = new Label("Login Form", 0, 10, 300, 20);
      innerText.getStyle().setTextColor(1f, 0.5f, 0, 1f).setHorizontalAlign(HorizontalAlign.CENTER);
      innerText.getStyle().setFont(FontRegistry.ROBOTO_BOLD).setFontSize(30f);
      textInputDemo.getContainer().add(innerText);

      Label usernameLabel = new Label("Username", 10, 50, 280, 20);
      textInputDemo.getContainer().add(usernameLabel);

      TextInput usernameInput = new TextInput("Username", 10, 70, 280, 30);
      usernameInput.getStyle().setFontSize(20f).setVerticalAlign(VerticalAlign.MIDDLE);
      textInputDemo.getContainer().add(usernameInput);

      Label passwordLabel = new Label("Password", 10, 110, 280, 20);
      textInputDemo.getContainer().add(passwordLabel);

      PasswordInput passwordInput = new PasswordInput("Password", 10, 130, 280, 30);
      passwordInput.getStyle().setFontSize(20f).setVerticalAlign(VerticalAlign.MIDDLE);
      textInputDemo.getContainer().add(passwordInput);

      Label forgotPasswordLabel = new Label("Forgot password?", 10, 160, 280, 20);
      forgotPasswordLabel.getStyle().setTextColor(77 / 256f, 165 / 256f, 238 / 256f, 1f);
      forgotPasswordLabel.getHoveredStyle().setTextColor(137 / 256f, 195 / 256f, 242 / 256f, 1f);
      textInputDemo.getContainer().add(forgotPasswordLabel);

      Button loginButton = new Button("Login", 10, 190, 280, 30);
      loginButton.getStyle().setFont(FontRegistry.ROBOTO_BOLD).setFontSize(20f);
      loginButton.getStyle().setHorizontalAlign(HorizontalAlign.CENTER).setVerticalAlign(VerticalAlign.MIDDLE);
      loginButton.getStyle().setTextColor(1f, 1f, 1f, 1f);
      loginButton.getStyle().getBackground().setColor(19 / 256f, 92 / 256f, 236 / 256f, 1f);
      loginButton.getHoveredStyle().getBackground().setColor(11 / 256f, 61 / 256f, 161 / 256f, 1f);
      textInputDemo.getContainer().add(loginButton);

      this.add(textInputDemo);
    }

    Widget imageWrapper = new Widget(20, 30, 100, 100);
    {
      imageWrapper.setAscendible(true);
      imageWrapper.setTitleEnabled(true);

      ImageView imageView = new ImageView(ImageLoader.loadImage(new Identifier("textures/gui/container/furnace.png")));
      imageView.setPosition(15, 5).setSize(256, 256).getStyle().setBorderRadius(10f);

      imageWrapper.getTitle().getTextState().setText("Ascendible widget");
      imageWrapper.getContainer().add(imageView);
      imageWrapper.setCloseable(false);

      this.add(imageWrapper);
    }

    Widget flexDemo = new Widget("Flex Layout Demo", 150, 400, 300, 150);
    {
      flexDemo.getContainer().getStyle().setDisplay(Style.DisplayType.FLEX);
      flexDemo.getContainer().getFlexStyle().setFlexDirection(FlexStyle.FlexDirection.COLUMN);

      Label one = new Label("Hello Flex World");
      one.getStyle().enableFlex(200, 30).setFont(FontRegistry.ROBOTO_BOLD).setFontSize(25f);
      flexDemo.getContainer().add(one);

      Label two = new Label("this is a description");
      two.getStyle().enableFlex(200, 20).setTextColor(1, 0.5f, 0, 1);
      flexDemo.getContainer().add(two);

      FlexPanel across = new FlexPanel(300, 50);
      across.getStyle().setMargin(5, 0, 5, 0).getBackground().setColor(0, 1, 0, 0.2f);
      across.getFlexStyle().setAlignItems(FlexStyle.AlignItems.CENTER).setJustifyContent(FlexStyle.JustifyContent.CENTER);

      Label left = new Label("Name");
      left.getStyle().enableFlex(100, 20).setHorizontalAlign(HorizontalAlign.RIGHT).setFontSize(20f).setPadding(2.5f);
      across.add(left);

      TextInput right = new TextInput();
      right.getStyle().enableFlex(140, 35).setFontSize(20f).setPadding(2.5f);
      across.add(right);

      flexDemo.getContainer().add(across);

      FlexPanel across2 = new FlexPanel(600, 50);
      across2.getStyle().setMargin(5, 0, 5, 0).getBackground().setColor(1, 0, 0, 0.2f);
      across2.getFlexStyle().setAlignItems(FlexStyle.AlignItems.CENTER);


      Label flexLabel1 = new FlexLabel("Hello");
      flexLabel1.getStyle().setFontSize(20f).setTextColor(0, 1, 1, 1).setMargin(0, 5);
      flexLabel1.getStyle().getBackground().setColor(1, 1, 0, 0.5f);

      Label flexLabel2 = new FlexLabel("This is some more text");
      flexLabel2.getStyle().setFontSize(20f).setMargin(0, 5);
      flexLabel2.getStyle().getBackground().setColor(0, 1, 0, 0.5f);

      Label flexLabel3 = new FlexLabel("World");
      flexLabel3.getStyle().setFontSize(20f).setTextColor(0, 0.5f, 1, 1).setMargin(0, 5);
      flexLabel3.getStyle().getBackground().setColor(0, 1, 1, 0.5f);

      across2.add(flexLabel1).add(flexLabel2).add(flexLabel3);
      flexDemo.getContainer().add(across2);

      this.add(flexDemo);
    }
  }
}
