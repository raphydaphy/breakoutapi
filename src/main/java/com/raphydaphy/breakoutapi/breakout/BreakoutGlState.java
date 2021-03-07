package com.raphydaphy.breakoutapi.breakout;

import com.mojang.blaze3d.platform.GlStateManager;
import com.raphydaphy.breakoutapi.mixin.client.CapabilityTrackerAccessor;
import com.raphydaphy.breakoutapi.mixin.client.GlStateManagerAccessor;

public class BreakoutGlState {
  private final boolean[] lightsEnabled = new boolean[8];
  private boolean lighting;

  private int depthFunc;
  private boolean depthMask;
  private boolean depthTestEnabled;

  private boolean alphaTestEnabled;
  private float alphaRef;
  private int alphaFunc;

  private boolean colorMaterialEnabled;
  private int colorMaterialFace;
  private int colorMaterialMode;

  private boolean blendEnabled;
  private int blendSrcFactorRGB;
  private int blendDstFactorRGB;
  private int blendSrcFactorAlpha;
  private int blendDstFactorAlpha;

  private boolean fogEnabled;
  private int fogMode;
  private float fogDensity;
  private float fogStart;
  private float fogEnd;

  private boolean cullEnabled;
  private int cullMode;

  private boolean polyOffsetFill;
  private boolean polyOffsetLine;
  private float polyOffsetFactor;
  private float polyOffsetUnits;

  private boolean colorLogicEnabled;
  private int colorLogicOp;

  private final int[] texGenModes = new int[4];
  private final boolean[] texGenCoordsEnabled = new boolean[4];

  private int stencilSubFunc;
  private int stencilSubRef;
  private int stencilSubMask;
  private int stencilMask;
  private int stencilSfail;
  private int stencilDpfail;
  private int stencilDppass;

  private boolean scissorTestEnabled;

  private int activeTexture;
  private final boolean[] texturesEnabled = new boolean[12];
  private final int[] texturesBoundTextures = new int[12];

  public void record() {
    GlStateManager.DepthTestState depth = GlStateManagerAccessor.getDepth();
    depthFunc = depth.func;
    depthMask = depth.mask;
    depthTestEnabled = ((CapabilityTrackerAccessor) depth.capState).getState();

    GlStateManager.CapabilityTracker[] lights = GlStateManagerAccessor.getLightsEnabled();
    for (int i = 0; i < 8; i++) {
      lightsEnabled[i] = ((CapabilityTrackerAccessor) lights[i]).getState();
    }

    lighting = ((CapabilityTrackerAccessor)GlStateManagerAccessor.getLighting()).getState();

    GlStateManager.AlphaTestState alpha = GlStateManagerAccessor.getAlphaTest();
    alphaFunc = alpha.func;
    alphaRef = alpha.ref;
    alphaTestEnabled = ((CapabilityTrackerAccessor) alpha.capState).getState();

    GlStateManager.ColorMaterialState colorMaterial = GlStateManagerAccessor.getColorMaterial();
    colorMaterialFace = colorMaterial.face;
    colorMaterialMode = colorMaterial.mode;
    colorMaterialEnabled = ((CapabilityTrackerAccessor) colorMaterial.capState).getState();

    GlStateManager.BlendFuncState blend = GlStateManagerAccessor.getBlend();
    blendEnabled = ((CapabilityTrackerAccessor)blend.capState).getState();
    blendSrcFactorRGB = blend.srcFactorRGB;
    blendDstFactorRGB = blend.dstFactorRGB;
    blendSrcFactorAlpha = blend.srcFactorAlpha;
    blendDstFactorAlpha = blend.dstFactorAlpha;

    GlStateManager.FogState fog = GlStateManagerAccessor.getFog();
    fogEnabled = ((CapabilityTrackerAccessor)fog.capState).getState();
    fogMode = fog.mode;
    fogDensity = fog.density;
    fogStart = fog.start;
    fogEnd = fog.end;

    GlStateManager.CullFaceState cull = GlStateManagerAccessor.getCull();
    cullEnabled = ((CapabilityTrackerAccessor)cull.capState).getState();
    cullMode = cull.mode;

    GlStateManager.PolygonOffsetState polyOffset = GlStateManagerAccessor.getPolyOffset();
    polyOffsetFill = ((CapabilityTrackerAccessor)polyOffset.capFill).getState();
    polyOffsetLine = ((CapabilityTrackerAccessor)polyOffset.capLine).getState();
    polyOffsetFactor = polyOffset.factor;
    polyOffsetUnits = polyOffset.units;

    GlStateManager.LogicOpState colorLogic = GlStateManagerAccessor.getColorLogic();
    colorLogicEnabled = ((CapabilityTrackerAccessor)colorLogic.capState).getState();
    colorLogicOp = colorLogic.op;

    GlStateManager.TexGenState texGen = GlStateManagerAccessor.getTexGen();
    texGenModes[0] = texGen.s.mode;
    texGenCoordsEnabled[0] = ((CapabilityTrackerAccessor)texGen.s.capState).getState();
    texGenModes[1] = texGen.t.mode;
    texGenCoordsEnabled[1] = ((CapabilityTrackerAccessor)texGen.t.capState).getState();
    texGenModes[2] = texGen.r.mode;
    texGenCoordsEnabled[2] = ((CapabilityTrackerAccessor)texGen.r.capState).getState();
    texGenModes[3] = texGen.q.mode;
    texGenCoordsEnabled[3] = ((CapabilityTrackerAccessor)texGen.q.capState).getState();

    GlStateManager.StencilState stencil = GlStateManagerAccessor.getStencil();
    stencilSubFunc = stencil.subState.func;
    stencilSubRef = stencil.subState.ref;
    stencilSubMask = stencil.subState.mask;
    stencilMask = stencil.mask;
    stencilSfail = stencil.sfail;
    stencilDpfail = stencil.dpfail;
    stencilDppass = stencil.dppass;

    GlStateManager.ScissorTestState scissorTest = GlStateManagerAccessor.getScissorTest();
    scissorTestEnabled = ((CapabilityTrackerAccessor)scissorTest.capState).getState();


  }

  public void apply() {
    GlStateManager.DepthTestState depth = GlStateManagerAccessor.getDepth();
    depth.func = depthFunc;
    depth.mask = depthMask;
    ((CapabilityTrackerAccessor)depth.capState).setStateInternal(depthTestEnabled);

    GlStateManager.CapabilityTracker[] lights = GlStateManagerAccessor.getLightsEnabled();
    for (int i = 0; i < 8; i++) {
      ((CapabilityTrackerAccessor) lights[i]).setStateInternal(lightsEnabled[i]);
    }

    ((CapabilityTrackerAccessor)GlStateManagerAccessor.getLighting()).setStateInternal(lighting);

    GlStateManager.AlphaTestState alpha = GlStateManagerAccessor.getAlphaTest();
    alpha.func = alphaFunc;
    alpha.ref = alphaRef;
    ((CapabilityTrackerAccessor)alpha.capState).setStateInternal(alphaTestEnabled);

    GlStateManager.ColorMaterialState colorMaterial = GlStateManagerAccessor.getColorMaterial();
    colorMaterial.face = colorMaterialFace;
    colorMaterial.mode = colorMaterialMode;
    ((CapabilityTrackerAccessor)colorMaterial.capState).setStateInternal(colorMaterialEnabled);

    GlStateManager.BlendFuncState blend = GlStateManagerAccessor.getBlend();
    ((CapabilityTrackerAccessor)blend.capState).setStateInternal(blendEnabled);
    blend.srcFactorRGB = blendSrcFactorRGB;
    blend.dstFactorRGB = blendDstFactorRGB;
    blend.srcFactorAlpha = blendSrcFactorAlpha;
    blend.dstFactorAlpha = blendDstFactorAlpha;

    GlStateManager.FogState fog = GlStateManagerAccessor.getFog();
    ((CapabilityTrackerAccessor)fog.capState).setStateInternal(fogEnabled);
    fog.mode = fogMode;
    fog.density = fogDensity;
    fog.start = fogStart;
    fog.end = fogEnd;

    GlStateManager.CullFaceState cull = GlStateManagerAccessor.getCull();
    ((CapabilityTrackerAccessor)cull.capState).setStateInternal(cullEnabled);
    cull.mode = cullMode;

    GlStateManager.PolygonOffsetState polyOffset = GlStateManagerAccessor.getPolyOffset();
    ((CapabilityTrackerAccessor)polyOffset.capFill).setStateInternal(polyOffsetFill);
    ((CapabilityTrackerAccessor)polyOffset.capLine).setStateInternal(polyOffsetLine);
    polyOffset.factor = polyOffsetFactor;
    polyOffset.units = polyOffsetUnits;

    GlStateManager.LogicOpState colorLogic = GlStateManagerAccessor.getColorLogic();
    ((CapabilityTrackerAccessor)colorLogic.capState).setStateInternal(colorLogicEnabled);
    colorLogic.op = colorLogicOp;

    GlStateManager.TexGenState texGen = GlStateManagerAccessor.getTexGen();
    texGen.s.mode = texGenModes[0];
    ((CapabilityTrackerAccessor)texGen.s.capState).setStateInternal(texGenCoordsEnabled[0]);
    texGen.t.mode = texGenModes[1];
    ((CapabilityTrackerAccessor)texGen.t.capState).setStateInternal(texGenCoordsEnabled[1]);
    texGen.r.mode = texGenModes[2];
    ((CapabilityTrackerAccessor)texGen.r.capState).setStateInternal(texGenCoordsEnabled[2]);
    texGen.q.mode = texGenModes[3];
    ((CapabilityTrackerAccessor)texGen.q.capState).setStateInternal(texGenCoordsEnabled[3]);

    GlStateManager.StencilState stencil = GlStateManagerAccessor.getStencil();
    stencil.subState.func = stencilSubFunc;
    stencil.subState.ref = stencilSubRef;
    stencil.subState.mask = stencilSubMask;
    stencil.mask = stencilMask;
    stencil.sfail = stencilSfail;
    stencil.dpfail = stencilDpfail;
    stencil.dppass = stencilDppass;

    GlStateManager.ScissorTestState scissorTest = GlStateManagerAccessor.getScissorTest();
    ((CapabilityTrackerAccessor)scissorTest.capState).setStateInternal(scissorTestEnabled);
  }
}
