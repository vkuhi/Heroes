package com.heroes.actions;

import com.heroes.Captcha;
import com.heroes.pages.WorkPage;
import java.io.File;

public class WorkActions {

  private WorkPage workPage = new WorkPage();

  public boolean isEnteredCaptchaCorrect(Captcha captcha) throws Exception {
    boolean isEnteredCaptchaCorrect = workPage.isEnteredCaptchaCorrect();
    if (!isEnteredCaptchaCorrect) {
      captcha.sendBadCaptchaReport();
    }
    return isEnteredCaptchaCorrect;
  }

  public WorkActions pasteCaptcha(String captcha) {
    workPage.pasteCaptcha(captcha);
    return this;
  }

  public WorkActions clickSubmitButton() {
    workPage.clickSubmitButton();
    return this;
  }

  public File getCaptchaImage() throws Exception {
    return workPage.getCaptchaImage();
  }
}
