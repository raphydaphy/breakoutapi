package com.raphydaphy.breakoutapi.network;

import com.raphydaphy.breakoutapi.BreakoutAPI;
import com.raphydaphy.breakoutapi.BreakoutAPIClient;
import com.raphydaphy.breakoutapi.editor.Breakout;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.MinecraftClient;

public class ClientModPackets {
  public static void register() {
    ClientPlayNetworking.registerGlobalReceiver(ModPackets.BREAKOUT_TEST_PACKET, (client, handler, buf, responseSender) -> {
      client.execute(() -> {
        BreakoutAPI.LOGGER.info("Breakout test triggered on client");
        if (BreakoutAPIClient.CUR_BREAKOUT != null) {
          BreakoutAPI.LOGGER.warn("Tried to open the demo breakout when it was already open");
          return;
        }

        MinecraftClient.getInstance().openPauseMenu(true);
        BreakoutAPIClient.CUR_BREAKOUT = new Breakout();
      });
    });
  }
}
