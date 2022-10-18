package api;

import static endpoints.Endpoints.ANSWERS;
import static io.restassured.RestAssured.given;
import static java.lang.String.format;
import static org.apache.http.HttpStatus.SC_OK;
import static org.testng.Assert.assertTrue;
import static properties.ApiProperties.getValueOf;
import static properties.ApiPropertiesConst.FILTER_QUERY_PARAM;
import static properties.ApiPropertiesConst.FILTER_QUERY_PARAM_DEFAULT_VALUE;
import static properties.ApiPropertiesConst.ORDER_QUERY_PARAM;
import static properties.ApiPropertiesConst.ORDER_QUERY_PARAM_DESC_VALUE;
import static properties.ApiPropertiesConst.PAGE_QUERY_PARAM;
import static properties.ApiPropertiesConst.PAGE_SIZE_QUERY_PARAM;
import static properties.ApiPropertiesConst.SITE_QUERY_PARAM;
import static properties.ApiPropertiesConst.SITE_QUERY_PARAM_VALUE;
import static properties.ApiPropertiesConst.SORT_QUERY_PARAM;
import static properties.ApiPropertiesConst.SORT_QUERY_PARAM_ACTIVITY_VALUE;

import business_objects.Item;
import java.util.List;
import org.testng.annotations.Test;
import utils.StringUtils;


public class AnswersTest {

  private int page = 1;
  private int pageSize = 10;
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
        .queryParams(getValueOf(SITE_QUERY_PARAM), getValueOf(SITE_QUERY_PARAM_VALUE))
        .queryParams(getValueOf(PAGE_QUERY_PARAM), page)
        .queryParams(getValueOf(PAGE_SIZE_QUERY_PARAM), pageSize)
        .queryParams(getValueOf(ORDER_QUERY_PARAM), getValueOf(ORDER_QUERY_PARAM_DESC_VALUE))
        .queryParams(getValueOf(SORT_QUERY_PARAM), getValueOf(SORT_QUERY_PARAM_ACTIVITY_VALUE))
        .queryParams(getValueOf(FILTER_QUERY_PARAM), getValueOf(FILTER_QUERY_PARAM_DEFAULT_VALUE))
        .when()
        .get(ANSWERS)
        .then()
        .statusCode(SC_OK)
        .extract().body().jsonPath().getList("items", Item.class);
  }
}
