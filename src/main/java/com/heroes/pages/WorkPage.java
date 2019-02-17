package com.heroes.pages;

import static com.heroes.consts.ButtonText.ENROLL_BUTTON;
import static com.heroes.consts.Label.INVALID_CODE_PLEASE_TRY_AGAIN_LABEL;
import static com.heroes.consts.Label.YOU_HAVE_SUCCESSFULLY_ENROLLED_LABEL;

import com.heroes.Element;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;

public class WorkPage extends BasePage {

  private By incorrectCaptchaLabel = getByText(INVALID_CODE_PLEASE_TRY_AGAIN_LABEL);
  private By correctCaptchaLabel = getByText(YOU_HAVE_SUCCESSFULLY_ENROLLED_LABEL);
  private By captchaImage = getByXpath("//img[@name='imgcode']");
  private By captchaField = getById("code");
  private By enrollButton = getByXpath(String.format("//input[@value='%s']", ENROLL_BUTTON));

  public boolean isEnteredCaptchaCorrect() {
    return isElementPresent(correctCaptchaLabel);
  }

  public void pasteCaptcha(String captcha) {
    new Element(captchaField).sendKeys(captcha);
  }

  public void clickSubmitButton() {
    new Element(enrollButton).click();
  }

  public File getCaptchaImage() throws Exception {
    String logoSRC = new Element(captchaImage).getValueByAttribute("src");
    URL imageURL = new URL(logoSRC);
    File imageFile = new File("captcha.jpg");
    BufferedImage bufferedImage = ImageIO.read(imageURL);
    ImageIO.write(bufferedImage, "jpg", imageFile);
    return imageFile;
  }
}
