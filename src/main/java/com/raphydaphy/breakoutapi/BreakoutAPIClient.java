package com.raphydaphy.breakoutapi;

import com.raphydaphy.breakoutapi.editor.Breakout;
import com.raphydaphy.breakoutapi.network.ClientModPackets;
import net.fabricmc.api.ClientModInitializer;

public class BreakoutAPIClient implements ClientModInitializer {
  public static Breakout CUR_BREAKOUT = null;

  @Override
  public void onInitializeClient() {
    ClientModPackets.register();
  }
}
