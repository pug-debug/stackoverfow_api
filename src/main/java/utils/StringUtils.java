package utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import org.apache.commons.text.StringEscapeUtils;

public class StringUtils {

  public static String slugify(String displayName) {
    return
        StringEscapeUtils.unescapeHtml4(
            Normalizer
                .normalize(displayName, Form.NFD)
                .replaceAll("[\\._\\s]+", "-")
                .replaceAll("[-]+", "-")
                .replaceAll("^-", "")
                .replaceAll("-$", "")
                .toLowerCase());
  }

  public static String decodeSpecialSymbolsInURL(String url) {
    String decodedUrl = "";
    try {
      decodedUrl = URLDecoder.decode(url, "UTF-8");
    } catch (UnsupportedEncodingException e) {
      decodedUrl = url;
    }
    return decodedUrl;
  }
}
