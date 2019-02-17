package com.heroes;

import static com.heroes.consts.Link.LORDSWM_WEBSITE_LINK;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

  private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

  public static WebDriver getDriver() {
    WebDriver driver = threadDriver.get();
    if (driver != null) {
      return driver;
    }
    System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.get(LORDSWM_WEBSITE_LINK);
    threadDriver.set(driver);
    return driver;
  }

  public static void dismissDriver() {
    WebDriver driver = threadDriver.get();
    if (driver != null) {
      driver.quit();
      threadDriver.remove();
    }
  }
}
