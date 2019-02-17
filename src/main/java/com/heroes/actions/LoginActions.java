package com.heroes.actions;

import com.heroes.pages.LoginPage;

public class LoginActions {

  private LoginPage loginPage = new LoginPage();

  public LoginActions enterLogin(String login) {
    loginPage.enterLogin(login);
    return this;
  }

  public LoginActions enterPassword(String password) {
    loginPage.enterPassword(password);
    return this;
  }

  public LoginActions clickButtonSubmit() {
    loginPage.clickButtonSubmit();
    return this;
  }
}
