package com.raphydaphy.breakoutapi.network;

import com.raphydaphy.breakoutapi.BreakoutAPI;
import com.raphydaphy.breakoutapi.BreakoutAPIClient;
import com.raphydaphy.breakoutapi.demo.gui.DemoGUIBreakout;
import com.raphydaphy.breakoutapi.demo.integrated.DemoIntegratedBreakout;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.util.Identifier;

import java.util.Random;

public class ClientModPackets {
  public static void register() {
    ClientPlayNetworking.registerGlobalReceiver(ModPackets.BREAKOUT_TEST_PACKET, (client, handler, buf, responseSender) -> {
      String type = buf.readString();

      client.execute(() -> {
        BreakoutAPI.LOGGER.info("Breakout test triggered on client");
        String randomId = "" + new Random().nextDouble();

        if (type.equals("gui")) {
          Identifier id = new Identifier(BreakoutAPI.MODID, "gui-" + randomId);
          BreakoutAPIClient.openBreakout(id, new DemoGUIBreakout(id));
        } else if (type.equals("integrated")) {
          Identifier id = new Identifier(BreakoutAPI.MODID, "integrated-" + randomId);
          BreakoutAPIClient.openBreakout(id, new DemoIntegratedBreakout(id));
        } else {
          BreakoutAPI.LOGGER.warn("Tried to trigger invalid breakout type '" + type + "'");
        }
      });
    });
  }
}
