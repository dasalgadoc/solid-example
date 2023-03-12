package com.dsalgado.solid.domain.notifications;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReceiverEmail extends NotificationReceiver {
  private static final Pattern EMAIL_PATTERN =
      Pattern.compile(
          "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
              + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
  private String email;

  public ReceiverEmail(String email) {
    if (!isReceiverValid(email)) {
      throw new ReceiverNotValid();
    }
    this.email = email;
  }

  @Override
  public String receiver() {
    return email;
  }

  @Override
  protected boolean isReceiverValid(String receiver) {
    Matcher matcher = EMAIL_PATTERN.matcher(receiver);
    return matcher.matches();
  }
}
