package endpoints;

import static properties.ApiProperties.getValueOf;

public class Endpoints {

  private static final String BASE_URL = getValueOf("base.url");
  private static final String API_VERSION = getValueOf("api.version");

  // Endpoints
  public static final String ANSWERS = BASE_URL + "/" + API_VERSION + "/answers";

}
