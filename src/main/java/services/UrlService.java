package services;

import exception.InvalidUrlException;

public interface UrlService {

  String getOriginalUrl(String url) throws InvalidUrlException;

  String getEncodedUrl(String url) throws InvalidUrlException;
}
