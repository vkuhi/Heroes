package com.heroes.pages;

import com.heroes.Element;
import org.openqa.selenium.By;

public class MapPage extends BasePage {

  private By firstMiningWork = getByXpath("//table/tbody/tr/td[3]/table/tbody/tr[2]/td[@class='wbwhite'][1]");

  public void openFirstMiningWork() {
    new Element(firstMiningWork).click();
  }
}
