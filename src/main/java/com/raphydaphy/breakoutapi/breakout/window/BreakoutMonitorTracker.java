package com.raphydaphy.breakoutapi.breakout.window;

import com.raphydaphy.breakoutapi.mixin.client.MonitorTrackerMixin;
import com.raphydaphy.breakoutapi.mixin.client.WindowMixin;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.Monitor;
import net.minecraft.client.util.MonitorTracker;
import net.minecraft.util.math.MathHelper;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.glfw.GLFW;

public class BreakoutMonitorTracker {
  @Nullable
  public static Monitor getMonitor(BreakoutWindow window) {
    MinecraftClient client = MinecraftClient.getInstance();
    MonitorTracker tracker = ((WindowMixin)(Object)(client.getWindow())).getMonitorTracker();
    long l = GLFW.glfwGetWindowMonitor(window.getHandle());
    if (l != 0L) {
      return tracker.getMonitor(l);
    } else {
      int windowStartX = window.getX();
      int windowEndX = windowStartX + window.getWidth();
      int windowStartY = window.getY();
      int windowEndY = windowStartY + window.getHeight();
      int n = -1;
      Monitor monitor = null;

      for (Monitor monitor2 : ((MonitorTrackerMixin) tracker).getPointerToMonitorMap().values()) {
        int monitorStartX = monitor2.getViewportX();
        int monitorEndX = monitorStartX + monitor2.getCurrentVideoMode().getWidth();
        int monitorStartY = monitor2.getViewportY();
        int monitorEndY = monitorStartY + monitor2.getCurrentVideoMode().getHeight();
        int s = MathHelper.clamp(windowStartX, monitorStartX, monitorEndX);
        int t = MathHelper.clamp(windowEndX, monitorStartX, monitorEndX);
        int u = MathHelper.clamp(windowStartY, monitorStartY, monitorEndY);
        int v = MathHelper.clamp(windowEndY, monitorStartY, monitorEndY);
        int w = Math.max(0, t - s);
        int x = Math.max(0, v - u);
        int y = w * x;
        if (y > n) {
          monitor = monitor2;
          n = y;
        }
      }

      return monitor;
    }
  }
}
