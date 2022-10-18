package endpoints;

import static properties.ApiProperties.getValueOf;

import properties.ApiPropertiesConst;

public class Endpoints {

  private static final String BASE_URL = getValueOf(ApiPropertiesConst.BASE_URL);
  private static final String API_VERSION = getValueOf(ApiPropertiesConst.API_VERSION);

  // Endpoints
  public static final String ANSWERS = BASE_URL + "/" + API_VERSION + "/answers";

}
