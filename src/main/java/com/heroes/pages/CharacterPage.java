package com.heroes.pages;

import static com.heroes.consts.ButtonText.LOGOUT_BUTTON;

import com.heroes.Element;
import org.openqa.selenium.By;

public class CharacterPage extends BasePage {

  private By logoutButton = getByText(LOGOUT_BUTTON);

  public void clickButtonLogout() {
    new Element(logoutButton).click();
  }
}
