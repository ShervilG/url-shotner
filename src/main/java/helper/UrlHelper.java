package helper;

import common.Constant;
import entities.Url;
import exception.InvalidUrlException;
import org.apache.commons.validator.routines.UrlValidator;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class UrlHelper {

  private UrlValidator urlValidator;

  public UrlHelper() {
    urlValidator = new UrlValidator();
  }

  public Long decodeUrl(String url) throws InvalidUrlException {

    if(checkUrlValidity(url)) {
      throw new InvalidUrlException("Invalid Url !");
    }

    int baseLength = Constant.BASE_URL.length();
    String encodedpart = url.substring(baseLength);
    Long decodedId = Long.parseLong(new String(Base64.getDecoder().decode(encodedpart.getBytes(StandardCharsets.UTF_8))));
    return decodedId;
  }

  public String encodeUrl(Url originalUrl) throws InvalidUrlException {

    if(checkUrlValidity(originalUrl.getValue())) {
      throw new InvalidUrlException("Invalid Url !");
    }

    String encoded = Base64.getEncoder().encodeToString((originalUrl.getId().toString())
      .getBytes(StandardCharsets.UTF_8));
    return encoded;
  }

  private boolean checkUrlValidity(String url) {
    return !urlValidator.isValid(url);
  }
}
