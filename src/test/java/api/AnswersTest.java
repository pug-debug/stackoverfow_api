package api;

import static endpoints.Endpoints.ANSWERS;
import static io.restassured.RestAssured.given;
import static java.lang.String.format;
import static org.apache.http.HttpStatus.SC_OK;
import static org.testng.Assert.assertTrue;

import business_objects.Item;
import java.util.List;
import org.testng.annotations.Test;
import utils.StringUtils;


public class AnswersTest {

  private String site = "stackoverflow";
  private int page = 1;
  private int pageSize = 10;
  private String order = "desc";
  private String sort = "activity";
  private String filter = "default";
  private String linkSample = "https://stackoverflow.com/users/%s/%s";
  private List<Item> listOfAnswers;

  @Test(description = "check number of answers on page")
  public void verifySizeOfListOfAnswers() {
    listOfAnswers = getListOfAnswers();
    assertTrue(listOfAnswers.size() <= pageSize, format("List size is more than %d", pageSize));
  }

  @Test(description = "check that each answer contains Owner")
  public void verifyThatEachListItemContainsOwner() {
    assertTrue(listOfAnswers.stream().allMatch(p -> p.getOwner() != null),
        "Not all items contain Owner!");
  }

  @Test(description = "check Owner's link")
  public void verifyThatEachOwnerLinkContainsDisplayNameAndUserId() {
    assertTrue(listOfAnswers.stream().allMatch(
        p -> (StringUtils.decodeSpecialSymbolsInURL(p.getOwner().getLink())
            .equalsIgnoreCase(format(linkSample, p.getOwner().getUserId(),
                StringUtils.slugify(p.getOwner().getDisplayName()))))),
        "Not all Owner links contain display_name and user_id!");
  }

  private List<Item> getListOfAnswers() {
    return given()
        .queryParams("site", site)
        .queryParams("page", page)
        .queryParams("pagesize", pageSize)
        .queryParams("order", order)
        .queryParams("sort", sort)
        .queryParams("filter", filter)
        .when()
        .get(ANSWERS)
        .then()
        .statusCode(SC_OK)
        .extract().body().jsonPath().getList("items", Item.class);
  }
}
