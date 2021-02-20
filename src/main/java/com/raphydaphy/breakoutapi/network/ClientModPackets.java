package com.raphydaphy.breakoutapi.network;

import com.raphydaphy.breakoutapi.BreakoutAPI;
import com.raphydaphy.breakoutapi.BreakoutAPIClient;
import com.raphydaphy.breakoutapi.breakout.Breakout;
import com.raphydaphy.breakoutapi.demo.DemoBreakout;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

public class ClientModPackets {
  public static void register() {
    ClientPlayNetworking.registerGlobalReceiver(ModPackets.BREAKOUT_TEST_PACKET, (client, handler, buf, responseSender) -> {
      client.execute(() -> {
        BreakoutAPI.LOGGER.info("Breakout test triggered on client");
        if (BreakoutAPIClient.CUR_BREAKOUT != null) {
          BreakoutAPI.LOGGER.warn("Tried to open the demo breakout when it was already open");
          return;
        }

        BreakoutAPIClient.CUR_BREAKOUT = new DemoBreakout();
      });
    });
  }
}
