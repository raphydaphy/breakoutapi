package com.raphydaphy.breakoutapi.breakout.window.callback;

import org.liquidengine.legui.system.context.DefaultCallbackKeeper;

public class BreakoutWindowCallbackKeeper extends DefaultCallbackKeeper {
  private IChainResolutionChangedCallback chainResolutionChangedCallback = new ChainResolutionChangedCallback();

  public IChainResolutionChangedCallback getChainResolutionChangedCallback() {
    return chainResolutionChangedCallback;
  }

  public void setChainResolutionChangedCallback(IChainResolutionChangedCallback chainWindowIconifyCallback) {
    this.chainResolutionChangedCallback = chainWindowIconifyCallback;
  }
}
