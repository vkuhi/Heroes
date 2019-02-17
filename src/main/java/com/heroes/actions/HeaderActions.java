package com.heroes.actions;

import com.heroes.pages.HeaderPage;

public class HeaderActions {

  private HeaderPage headerPage = new HeaderPage();

  public CharacterActions clickCharacter() {
    headerPage.clickCharacter();
    return new CharacterActions();
  }

  public MapActions clickMap() {
    headerPage.clickMap();
    return new MapActions();
  }
}
