package com.raphydaphy.breakoutapi;

import com.raphydaphy.breakoutapi.command.ModCommands;
import com.raphydaphy.breakoutapi.network.ModPackets;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BreakoutAPI implements ModInitializer {
  public static String MODID = "breakoutapi";
  public static final Logger LOGGER = LogManager.getLogger("Breakout API");

  @Override
  public void onInitialize() {
    ModCommands.register();
    ModPackets.register();
  }
}
