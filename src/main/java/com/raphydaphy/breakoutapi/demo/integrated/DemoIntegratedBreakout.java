package com.raphydaphy.breakoutapi.demo.integrated;

import com.mojang.blaze3d.platform.GlStateManager;
import com.raphydaphy.breakoutapi.BreakoutAPI;
import com.raphydaphy.breakoutapi.breakout.AbstractBreakout;
import com.raphydaphy.breakoutapi.breakout.Breakout;
import com.raphydaphy.breakoutapi.breakout.window.BreakoutWindow;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Style;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

public class DemoIntegratedBreakout extends Breakout {
  private static Identifier LEAVES_TEXTURE = new Identifier("textures/block/azalea_leaves.png");
  private static Identifier FURNACE_GUI = new Identifier("textures/gui/container/furnace.png");

  public DemoIntegratedBreakout(Identifier identifier) {
    super(identifier, new BreakoutWindow("Demo Integrated Breakout", 480, 720));
    this.window.setIcon(new Identifier(BreakoutAPI.MODID, "textures/icons/window_icon_16x16.png"), new Identifier(BreakoutAPI.MODID, "textures/icons/window_icon_32x32.png"));
    this.window.setRelativePos(this.client.getWindow().getWidth() + 60, 0);
  }

  @Override
  public void render() {
    super.render();

    MatrixStack stack = new MatrixStack();

    this.client.getTextureManager().bindTexture(FURNACE_GUI);
    DrawableHelper.drawTexture(stack, 10, 10, 0, 0, 0, 256, 256, 256, 256);

    this.client.getTextureManager().bindTexture(LEAVES_TEXTURE);
    DrawableHelper.drawTexture(stack, 300, 50, 0, 0, 0, 180, 300, 32, 32);

    GlStateManager.color4f(1, 0, 1, 1);
    GlStateManager.scaled(3, 3, 1);

    DrawableHelper.drawCenteredText(stack, this.client.textRenderer, new LiteralText("hello world").setStyle(Style.EMPTY.withBold(true).withItalic(true).withColor(Formatting.RED)), 400 / 3, 11 / 3, 0);
    GlStateManager.color4f(1, 1, 1, 1);

    //client.textRenderer.draw(stack, "Hello world!", 100 / 3f, 50 / 3f, 0);
    GlStateManager.scaled(1/3f, 1/3f, 1);

    this.client.textRenderer.draw(stack, "normal scale :)", 300, 400, 0xffffff);
  }
}
