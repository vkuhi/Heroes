package com.heroes.pages;

import com.heroes.Element;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

  private By loginField = getByName("login");
  private By passwordField = getByName("pass");
  private By submitButton = getByClassName("entergame");

  public void enterLogin(String login) {
    new Element(loginField).sendKeys(login);
  }

  public void enterPassword(String password) {
    new Element(passwordField).sendKeys(password);
  }

  public void clickButtonSubmit() {
    new Element(submitButton).click();
  }
}
