package com.raphydaphy.breakoutapi.mixin.client;

import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import net.minecraft.client.util.Monitor;
import net.minecraft.client.util.MonitorTracker;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(MonitorTracker.class)
public interface MonitorTrackerMixin {
  @Accessor(value = "pointerToMonitorMap")
  Long2ObjectMap<Monitor> getPointerToMonitorMap();
}
