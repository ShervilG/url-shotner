package repos;

import entities.Url;

import java.util.HashMap;
import java.util.Map;

public class UrlRepository {

  private static Map<Long, Url> urlMap;

  static {
    urlMap = new HashMap<>();
  }

  public static void saveUrl(Url url) {
    urlMap.put(url.getId(), url);
  }

  public static Url getUrlById(Long id) {
    return urlMap.getOrDefault(id, null);
  }
}
