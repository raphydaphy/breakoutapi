package com.raphydaphy.breakoutapi.breakout.window.callback;

import org.lwjgl.system.CallbackI;

import static org.lwjgl.system.dyncall.DynCallback.*;

public interface IResolutionChangedCallback extends CallbackI.V {

    String SIGNATURE = "(ii)v";

    @Override
    default String getSignature() { return SIGNATURE; }

    @Override
    default void callback(long args) {
      invoke(
        dcbArgInt(args),
        dcbArgInt(args)
      );
    }

    void invoke(int width, int height);

  }