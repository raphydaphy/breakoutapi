package com.raphydaphy.breakoutapi.mixin.client;

import net.minecraft.client.render.BufferRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(BufferRenderer.class)
public interface BufferRendererAccessor {
  @Accessor("currentElementBufferObject")
  static int getCurrentElementBufferObject() {
    throw new IllegalStateException("Mixin not applied!");
  }

  @Accessor("currentElementBufferObject")
  static void setCurrentElementBufferObject(int ebo) {
    throw new IllegalStateException("Mixin not applied!");
  }

  @Accessor("currentVertexArrayObject")
  static int getCurrentVertexArrayObject() {
    throw new IllegalStateException("Mixin not applied!");
  }

  @Accessor("currentVertexArrayObject")
  static void setCurrentVertexArrayObject(int vao) {
    throw new IllegalStateException("Mixin not applied!");
  }

  @Accessor("currentVertexBufferObject")
  static int getCurrentVertexBufferObject() {
    throw new IllegalStateException("Mixin not applied!");
  }

  @Accessor("currentVertexBufferObject")
  static void setCurrentVertexBufferObject(int vbo) {
    throw new IllegalStateException("Mixin not applied!");
  }
}
