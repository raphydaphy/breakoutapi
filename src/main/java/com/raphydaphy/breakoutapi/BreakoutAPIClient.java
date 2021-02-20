package com.raphydaphy.breakoutapi;

import com.raphydaphy.breakoutapi.breakout.AbstractBreakout;
import com.raphydaphy.breakoutapi.breakout.Breakout;
import com.raphydaphy.breakoutapi.network.ClientModPackets;
import net.fabricmc.api.ClientModInitializer;

public class BreakoutAPIClient implements ClientModInitializer {
  public static AbstractBreakout CUR_BREAKOUT = null;

  @Override
  public void onInitializeClient() {
    ClientModPackets.register();
  }
}
