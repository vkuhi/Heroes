package com.heroes.actions;

import com.heroes.pages.CharacterPage;

public class CharacterActions {

  private CharacterPage characterPage = new CharacterPage();

  public LoginActions clickButtonLogout() {
    characterPage.clickButtonLogout();
    return new LoginActions();
  }
}
