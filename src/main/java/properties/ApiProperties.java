package properties;

import java.util.ResourceBundle;

public class ApiProperties {
  private static final ResourceBundle resource = ResourceBundle.getBundle("api");

  public static String getValueOf(String propertyName) {
    return resource.getString(propertyName);
  }
}
