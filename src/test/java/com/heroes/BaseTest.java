package com.heroes;

import org.testng.annotations.AfterSuite;

public abstract class BaseTest {

  @AfterSuite
  public void closeDriver() {
    Driver.dismissDriver();
  }
}
