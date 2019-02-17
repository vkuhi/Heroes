package com.heroes.pages;

import static com.heroes.consts.ButtonText.CHARACTER_BUTTON;
import static com.heroes.consts.ButtonText.MAP_BUTTON;

import com.heroes.Element;
import org.openqa.selenium.By;

public class HeaderPage extends BasePage {

  private By characterButton = getByText(CHARACTER_BUTTON);
  private By mapButton = getByText(MAP_BUTTON);

  public void clickCharacter() {
    new Element(characterButton).click();
  }

  public void clickMap() {
    new Element(mapButton).click();
  }
}
