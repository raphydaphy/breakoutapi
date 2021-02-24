package com.raphydaphy.breakoutapi.mixin.client;

import net.minecraft.client.util.MonitorTracker;
import net.minecraft.client.util.Window;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Window.class)
public interface WindowMixin {
  @Accessor(value = "monitorTracker")
  MonitorTracker getMonitorTracker();
}
