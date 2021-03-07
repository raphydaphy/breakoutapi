package com.raphydaphy.breakoutapi.mixin.client;

import com.mojang.blaze3d.platform.GlStateManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(GlStateManager.class)
public interface GlStateManagerAccessor {
  @Accessor("LIGHT_ENABLE")
  static GlStateManager.CapabilityTracker[] getLightsEnabled() {
    throw new IllegalStateException("Mixin not applied!");
  }

  @Accessor("DEPTH")
  static GlStateManager.DepthTestState getDepth() {
    throw new IllegalStateException("Mixin not applied!");
  }

  @Accessor("LIGHTING")
  static GlStateManager.CapabilityTracker getLighting() {
    throw new IllegalStateException("Mixin not applied!");
  }

  @Accessor("ALPHA_TEST")
  static GlStateManager.AlphaTestState getAlphaTest() {
    throw new IllegalStateException("Mixin not applied!");
  }

  @Accessor("COLOR_MATERIAL")
  static GlStateManager.ColorMaterialState getColorMaterial() {
    throw new IllegalStateException("Mixin not applied!");
  }

  @Accessor("BLEND")
  static GlStateManager.BlendFuncState getBlend() {
    throw new IllegalStateException("Mixin not applied!");
  }

  @Accessor("FOG")
  static GlStateManager.FogState getFog() {
    throw new IllegalStateException("Mixin not applied!");
  }

  @Accessor("CULL")
  static GlStateManager.CullFaceState getCull() {
    throw new IllegalStateException("Mixin not applied!");
  }

  @Accessor("POLY_OFFSET")
  static GlStateManager.PolygonOffsetState getPolyOffset() {
    throw new IllegalStateException("Mixin not applied!");
  }

  @Accessor("COLOR_LOGIC")
  static GlStateManager.LogicOpState getColorLogic() {
    throw new IllegalStateException("Mixin not applied!");
  }

  @Accessor("TEX_GEN")
  static GlStateManager.TexGenState getTexGen() {
    throw new IllegalStateException("Mixin not applied!");
  }

  @Accessor("STENCIL")
  static GlStateManager.StencilState getStencil() {
    throw new IllegalStateException("Mixin not applied!");
  }

  @Accessor("SCISSOR_TEST")
  static GlStateManager.ScissorTestState getScissorTest() {
    throw new IllegalStateException("Mixin not applied!");
  }

  @Accessor("activeTexture")
  static int getActiveTexture() {
    throw new IllegalStateException("Mixin not applied!");
  }

  @Accessor("activeTexture")
  static void setActiveTexture(int activeTexture) {
    throw new IllegalStateException("Mixin not applied!");
  }

  @Accessor("TEXTURES")
  static GlStateManager.Texture2DState[] getTextures() {
    throw new IllegalStateException("Mixin not applied!");
  }
}
