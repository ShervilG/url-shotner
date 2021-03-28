package util;

import common.InputType;
import exception.InvalidUrlException;
import services.UrlService;
import services.impl.UrlServiceImpl;

public class InputUtil {

  private UrlService urlService;

  public InputUtil() {
    urlService = new UrlServiceImpl();
  }

  public void handleInput(String inputString) {
    String[] commandArray = inputString.split(" ");
    if(commandArray.length < 2) {
      return;
    }
    String command = commandArray[0];
    String val = commandArray[1];

    if(command.equalsIgnoreCase(InputType.ENCODE.name())) {
      handleEncoding(val);
    }

    if(command.equalsIgnoreCase(InputType.DECODE.name())) {
      handleDecoding(val);
    }
  }

  private void handleEncoding(String val) {
    try {
      String encoded = urlService.getEncodedUrl(val);
      System.out.println(encoded);
    } catch (InvalidUrlException e) {
      System.out.println(e.getMessage());
    }
  }

  private void handleDecoding(String val) {
    try {
      String decoded = urlService.getOriginalUrl(val);
      if(decoded == null) {
        System.out.println("no url found !");
        return;
      }
      System.out.println(decoded);
    } catch (InvalidUrlException e) {
      System.out.println(e.getMessage());
    }
  }
}
