package com.raphydaphy.breakoutapi;

import com.raphydaphy.breakoutapi.breakout.AbstractBreakout;
import com.raphydaphy.breakoutapi.network.ClientModPackets;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.util.Identifier;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BreakoutAPIClient implements ClientModInitializer {
  private static Map<Identifier, AbstractBreakout> BREAKOUTS = new ConcurrentHashMap<>();

  @Override
  public void onInitializeClient() {
    ClientModPackets.register();
  }

  public static void openBreakout(AbstractBreakout breakout) {
    openBreakout(breakout.getIdentifier(), breakout);
  }

  public static void openBreakout(Identifier identifier, AbstractBreakout breakout) {
    if (BREAKOUTS.containsKey(identifier)) {
      BreakoutAPI.LOGGER.warn("Tried to open breakout '" + identifier + "' when it was already open!");
      return;
    }

    BREAKOUTS.put(identifier, breakout);
  }

  public static void closeBreakout(Identifier identifier) {
    if (!BREAKOUTS.containsKey(identifier)) {
      BreakoutAPI.LOGGER.warn("Tried to close breakout '" + identifier + "' which was not initially open");
      return;
    }

    BREAKOUTS.get(identifier).destroy();
    BREAKOUTS.remove(identifier);
  }

  public static Map<Identifier, AbstractBreakout> getBreakouts() {
    return BREAKOUTS;
  }
}
