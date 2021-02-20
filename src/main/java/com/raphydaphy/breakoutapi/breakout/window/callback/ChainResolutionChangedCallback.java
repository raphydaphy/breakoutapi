package com.raphydaphy.breakoutapi.breakout.window.callback;

import org.liquidengine.cbchain.AbstractChainCallback;

public class ChainResolutionChangedCallback extends AbstractChainCallback<IResolutionChangedCallback> implements IChainResolutionChangedCallback {
  public void invoke(int width, int height) {
    callbackChain.forEach(c -> c.invoke(width, height));
  }
}