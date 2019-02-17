package com.heroes;

import com.heroes.actions.CharacterActions;
import com.heroes.actions.HeaderActions;
import com.heroes.actions.LoginActions;
import com.heroes.actions.MapActions;
import com.heroes.actions.WorkActions;
import java.io.File;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WorkTest extends BaseTest {

  private LoginActions loginActions = new LoginActions();
  private HeaderActions headerActions = new HeaderActions();
  private MapActions mapActions = new MapActions();
  private CharacterActions characterActions = new CharacterActions();
  private WorkActions workActions = new WorkActions();
  private Captcha captcha;

  @AfterMethod
  public void tearDown() {
    logout();
  }

  @DataProvider(name = "Authentication")
  public static Object[][] credentials() {
    return new Object[][]{
        {"Vkuhi", "Vk123456"},
        {"darklle147", "qwerty147"}
    };
  }

  @Test(dataProvider = "Authentication")
  public void work(String login, String password) throws Exception {
    loginIntoAccount(login, password);
    do {
      headerActions.clickMap();
      mapActions.openFirstMiningWork();
      workActions.pasteCaptcha(getCaptchaText()).clickSubmitButton();
    } while (!workActions.isEnteredCaptchaCorrect(captcha));
  }

  private String getCaptchaText() throws Exception {
    File captchaImage = workActions.getCaptchaImage();
    captcha = new Captcha();
    return captcha.getCaptchaText(captchaImage);
  }

  private void loginIntoAccount(String login, String password) {
    loginActions
        .enterLogin(login)
        .enterPassword(password)
        .clickButtonSubmit();
  }

  private void logout() {
    headerActions.clickCharacter();
    characterActions.clickButtonLogout();
  }
}
