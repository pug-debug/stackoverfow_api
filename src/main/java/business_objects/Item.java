package business_objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {

  @JsonProperty("owner")
  private Owner owner;

  @JsonProperty("is_accepted")
  private boolean isAccepted;

  @JsonProperty("score")
  private int score;

  @JsonProperty("last_activity_date")
  private int lastActivityDate;

  @JsonProperty("last_edit_date")
  private int lastEditDate;

  @JsonProperty("creation_date")
  private int creationDate;

  @JsonProperty("answer_id")
  private int answerId;

  @JsonProperty("question_id")
  private int questionId;

  @JsonProperty("content_license")
  private String contentLicense;

  @JsonProperty("locked_date")
  private int lockedDate;

  @JsonProperty("community_owned_date")
  private int communityOwnedDate;

  public Item() {
  }

  public Item(Owner owner, boolean isAccepted, int score, int lastActivityDate, int lastEditDate,
      int creationDate, int answerId, int questionId, String contentLicense, int lockedDate,
      int communityOwnedDate) {
    this.owner = owner;
    this.isAccepted = isAccepted;
    this.score = score;
    this.lastActivityDate = lastActivityDate;
    this.lastEditDate = lastEditDate;
    this.creationDate = creationDate;
    this.answerId = answerId;
    this.questionId = questionId;
    this.contentLicense = contentLicense;
    this.lockedDate = lockedDate;
    this.communityOwnedDate = communityOwnedDate;
  }

  public Owner getOwner() {
    return owner;
  }

  public boolean isAccepted() {
    return isAccepted;
  }

  public int getScore() {
    return score;
  }

  public int getLastActivityDate() {
    return lastActivityDate;
  }

  public int getCreationDate() {
    return creationDate;
  }

  public int getAnswerId() {
    return answerId;
  }

  public int getQuestionId() {
    return questionId;
  }

  public String getContentLicense() {
    return contentLicense;
  }

  public int getLastEditDate() {
    return lastEditDate;
  }

  public int getLockedDate() {
    return lockedDate;
  }

  public int getCommunityOwnedDate() {
    return communityOwnedDate;
  }

  @Override
  public String toString() {
    return
        "{\n"
            + "    \"Owner\": " + owner.toString() + ",\n"
            + "    \"is_accepted\": " + isAccepted + ",\n"
            + "    \"score\": " + score + ",\n"
            + "    \"last_activity_date\": " + lastActivityDate + ",\n"
            + "    \"last_edit_date\": " + lastEditDate + ",\n"
            + "    \"creation_date\": " + creationDate + ",\n"
            + "    \"answer_id\": " + answerId + ",\n"
            + "    \"question_id\": " + questionId + ",\n"
            + "    \"content_license\": \"" + contentLicense + "\"\n"
            + "  }";
  }
}
