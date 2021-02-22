package com.raphydaphy.breakoutapi.command;

import static net.minecraft.server.command.CommandManager.*;

import com.raphydaphy.breakoutapi.BreakoutAPI;
import com.raphydaphy.breakoutapi.network.ModPackets;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.network.ServerPlayerEntity;

public class ModCommands {
  public static void register() {
    CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
      dispatcher.register(literal("breakouttest").then(literal("gui").executes(context -> {
        BreakoutAPI.LOGGER.info("GUI Breakout test requested on server");

        ServerPlayerEntity player = context.getSource().getPlayer();
        ServerPlayNetworking.send(player, ModPackets.BREAKOUT_TEST_PACKET, PacketByteBufs.create().writeString("gui"));

        return 0;
      })).then(literal("integrated").executes(context -> {
        BreakoutAPI.LOGGER.info("Integrated Breakout test requested on server");

        ServerPlayerEntity player = context.getSource().getPlayer();
        ServerPlayNetworking.send(player, ModPackets.BREAKOUT_TEST_PACKET, PacketByteBufs.create().writeString("integrated"));

        return 0;
      })));
    });
  }
}
