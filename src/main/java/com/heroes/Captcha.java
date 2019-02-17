package com.heroes;

import static com.heroes.consts.Exception.CAPTCHA_NOT_READY;
import static com.heroes.consts.PatternRegex.RESPONSE_WITHOUT_STATUS_PATTERN;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.marketer.RuCaptcha;

public class Captcha {

  private String id;

  private static final String API_KEY = "3c8c8a1e2b9212cf208d1b8e29691c40";

  public Captcha() {
    if (RuCaptcha.API_KEY == null) {
      RuCaptcha.API_KEY = API_KEY;
    }
  }

  public String getCaptchaText(File captchaImage) throws Exception {
    String idWithStatus = RuCaptcha.postCaptcha(captchaImage);
    id = parseValue(idWithStatus, RESPONSE_WITHOUT_STATUS_PATTERN);
    while (isCaptchaNotReady(id)) {
      Thread.sleep(5000);
    }
    String captchaWithStatus = RuCaptcha.getDecryption(id);
    String captcha = parseValue(captchaWithStatus, RESPONSE_WITHOUT_STATUS_PATTERN);
    return captcha;
  }

  public void sendBadCaptchaReport() throws Exception {
    RuCaptcha.reportBad(id);
  }

  private boolean isCaptchaNotReady(String id) throws Exception {
    return RuCaptcha.getDecryption(id).equals(CAPTCHA_NOT_READY);
  }

  private String parseValue(String response, String patternText) {
    Pattern pattern = Pattern.compile(patternText);
    Matcher matcher = pattern.matcher(response);
    matcher.find();
    return response.substring(matcher.start(), matcher.end());
  }
}
