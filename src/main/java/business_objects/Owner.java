package business_objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Owner {

  @JsonProperty("reputation")
  private int reputation;

  @JsonProperty("user_id")
  private int userId;

  @JsonProperty("user_type")
  private String userType;

  @JsonProperty("accept_rate")
  private int acceptRate;

  @JsonProperty("profile_image")
  private String profileImage;

  @JsonProperty("display_name")
  private String displayName;

  @JsonProperty("link")
  private String link;

  public Owner() {
  }

  public Owner(int reputation, int userId, String userType, int acceptRate,
      String profileImage, String displayName, String link) {
    this.reputation = reputation;
    this.userId = userId;
    this.userType = userType;
    this.acceptRate = acceptRate;
    this.profileImage = profileImage;
    this.displayName = displayName;
    this.link = link;
  }

  public int getReputation() {
    return reputation;
  }

  public int getUserId() {
    return userId;
  }

  public String getUserType() {
    return userType;
  }

  public String getProfileImage() {
    return profileImage;
  }

  public String getDisplayName() {
    return displayName;
  }

  public String getLink() {
    return link;
  }

  @Override
  public String toString() {
    return
        "{\n"
            + "    \"reputation\": " + reputation + ",\n"
            + "    \"user_id\": " + userId + ",\n"
            + "    \"user_type\": \"" + userType + "\",\n"
            + "    \"accept_rate\": " + acceptRate + ",\n"
            + "    \"profile_image\": \"" + profileImage + "\",\n"
            + "    \"display_name\": \"" + displayName + "\",\n"
            + "    \"link\": \"" + link + "\",\n"
            + "  }";
  }
}
