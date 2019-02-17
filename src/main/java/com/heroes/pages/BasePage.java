package com.heroes.pages;

import com.heroes.Driver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {

  private WebDriver driver = Driver.getDriver();

  protected boolean isElementPresent(By locator) {
    driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    boolean isPresent = driver.findElements(locator).size() > 0;
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    return isPresent;
  }

  protected By getByText(String text) {
    return By.xpath(String.format("//*[contains(text(), '%s')]", text));
  }

  protected By getByXpath(String xpath) {
    return By.xpath(xpath);
  }

  protected By getById(String id) {
    return By.id(id);
  }

  protected By getByName(String name) {
    return By.name(name);
  }

  protected By getByClassName(String className) {
    return By.className(className);
  }
}
