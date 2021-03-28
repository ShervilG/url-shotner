package services.impl;

import common.Constant;
import entities.Url;
import exception.InvalidUrlException;
import helper.UrlHelper;
import services.UrlService;
import repos.UrlRepository;

public class UrlServiceImpl implements UrlService {

  private UrlHelper urlHelper;

  public UrlServiceImpl() {
    urlHelper = new UrlHelper();
  }

  @Override
  public String getEncodedUrl(String url) throws InvalidUrlException {
    Url newUrl = new Url(url);
    String encoded;
    try {
      encoded = urlHelper.encodeUrl(newUrl);
    } catch (InvalidUrlException e) {
      throw e;
    }
    UrlRepository.saveUrl(newUrl);
    return Constant.BASE_URL + encoded;
  }

  @Override
  public String getOriginalUrl(String url) throws InvalidUrlException {
    Long decodedId = urlHelper.decodeUrl(url);
    Url urlNew = UrlRepository.getUrlById(decodedId);
    return (urlNew != null) ? urlNew.getValue() : null;
  }
}
