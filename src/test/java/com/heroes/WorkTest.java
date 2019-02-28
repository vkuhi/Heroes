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

  @AfterMethod
  public void tearDown() {
    logout();
  }

  @DataProvider(name = "Authentication")
  public static Object[][] credentials() {
    return new Object[][]{
        {"olep", "qwerty147"},
        {"kiril4ik", "qwerty147"},
        {"heroespox", "qwerty147"},
        {"Malish99", "qwerty147"},
        {"Rubi", "qwerty147"},
        {"Gorlik", "qwerty147"},
        {"Lilak", "qwerty147"},
        {"semavorop", "eVLy7IpTYXFB2io"},
        {"sergunchikchik", "qwerty147"},
        {"sergeylo777", "Ht9R7XpW4u8pfX"},
        {"serzhkharit", "1je2w53rImaBexU"},
        {"sofyadiv", "qPW5bqh7ZDQxJxF"},
        {"oleghazan", "py8QbtqPWCSn1Xe"},
        {"ritakach", "1PbkbUGIWpbpplE"},
        {"donduko", "Au61A9hyCdgpU1R"},
        {"tosyafili", "OIClSOgI9CtEZLX"},
        {"rayaash", "dSaLW8Z50sE9cWp"},
        {"Sosisozka", "LuBMYRNtz4jPSXs"},
        {"valentin_kula", "sxePjyfn4QX8Qe7HRz"},
        {"FedorSerov", "XoAY9BlB0P"},
        {"polinamali", "4iosRvHH360m1wh"},
        {"milagogol", "35vbANdqtN5FOGn"},
        {"gert447", "grom1515"},
        {"arinakoros", "CiEwnwcWtD6IKza"},
        {"allamaly", "Ib4FPf7vDtpDWcF"},
        {"andrejdor", "35vbANdqtN5FOGn"},
        {"voroni", "tpkGEN59W8k8HeT"},
        {"galagan", "KQfrQ7g2exKoKds"}
    };
  }

  @Test(dataProvider = "Authentication")
  public void work(String login, String password) throws Exception {
    Captcha captcha;
    loginIntoAccount(login, password);
    do {
      headerActions.clickMap();
      mapActions.openFirstMiningWork();
      captcha = new Captcha();
      workActions.pasteCaptcha(getCaptchaText(captcha)).clickSubmitButton();
    } while (!workActions.isEnteredCaptchaCorrect(captcha));
  }

  private String getCaptchaText(Captcha captcha) throws Exception {
    File captchaImage = workActions.getCaptchaImage();
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
