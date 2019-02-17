package com.heroes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Element {

  private WebDriver driver = Driver.getDriver();
  private By by;

  public Element(By by) {
    this.by = by;
  }

  private WebElement getMobileElement() {
    return driver.findElement(this.by);
  }

  public void sendKeys(String value) {
    getMobileElement().clear();
    getMobileElement().click();
    getMobileElement().sendKeys(value);
  }

  public void click() {
    getMobileElement().click();
  }

  public String getValueByAttribute(String name) {
    return getMobileElement().getAttribute(name);
  }
}
