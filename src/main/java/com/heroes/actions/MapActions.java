package com.heroes.actions;

import com.heroes.pages.MapPage;

public class MapActions {

  private MapPage mapPage = new MapPage();

  public MapActions openFirstMiningWork() {
    mapPage.openFirstMiningWork();
    return this;
  }
}
