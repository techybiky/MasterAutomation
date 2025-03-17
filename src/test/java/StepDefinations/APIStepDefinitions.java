package StepDefinations;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.Map;
import java.util.logging.Logger;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.APIConstants;

public class APIStepDefinitions {
	private String username;
	private String password;
	private Response response;
	private String endpoint;
	private static Logger logger = Logger.getLogger(APIStepDefinitions.class.getName());

	@Given("the base URL is {string}")
	public void theBaseURLIs(String baseURL) {
		RestAssured.baseURI = baseURL;
	}

	@Given("the API endpoint is {string}")
	public void theApiEndpointIs(String url) {
		this.endpoint = url;
	}

	@When("I make a GET request to {string}")
	public void iMakeAGETRequestTo(String endpoint) {
		response = given().get(endpoint);
	}

	@Then("the response status code should be {int}")
	public void theResponseStatusCodeShouldBe(int statusCode) {
		Assert.assertEquals(statusCode, response.statusCode());
	}

	@Then("the response should contain {string} with value {int}")
	public void theResponseShouldContainWithValue(String key, int value) {

		response.then().body(key + "[0]", equalTo(value));
		System.out.println("Expected : " + value + "  ");

	}

	@Then("the response should contain {string} and {string}")
	public void the_response_should_contain_and(String string, String string2) {
		response.then().body("[2].name", equalTo(string)).body("[2].email", equalTo(string2));
	}

	@Then("create a post request using below data")
	public void create_a_post_request_using_below_data(DataTable table) {
		Map<String, String> map = table.asMap(String.class, String.class);
		response = given().header("Contain-Type", "application/json").body(map).post(endpoint);
		logger.info("JSON Map" + map);
	}

	@When("I send a PUT request with the following data")
	public void i_send_a_put_request_with_the_following_data(DataTable table) {
		Map<String, String> map = table.asMap(String.class, String.class);
		response = given().header("Contain-Type", "application/json").body(map).post(endpoint);
		logger.info("JSON Map" + map);
	}

	@Then("response should contain")
	public void response_should_contain(DataTable table) {
		Map<String, String> expectedData = table.asMap(String.class, String.class);

		// Loop through the expected data and validate against response
		for (Map.Entry<String, String> entry : expectedData.entrySet()) {
			String key = entry.getKey();
			String expectedValue = entry.getValue();

			/// Fetch actual value from JSON response using JSONPath
			Object actualValue = response.jsonPath().get(key);

			// Convert actual value to String to avoid type mismatches
			String actualValueStr = String.valueOf(actualValue);

			if (!expectedValue.trim().equals(actualValueStr.trim())) {
				throw new AssertionError("Mismatch for key [" + key + "]: Expected [" + expectedValue + "] but found ["
						+ actualValueStr + "]");
			}
		}
	}

	@When("I send a Delete Request")
	public void i_send_a_delete_request() {
		response = given().delete(endpoint);
		logger.info("Endpoint Deleted");
	}

	@Then("Validate Auth Token")
	public void validate_auth() {

		response = given().auth().basic("username", "password").when().get("https://api.example.com/protected");
		response = given().auth().oauth("consumerKey", "consumerSecret", "accessToken", "secretToken").when().get();

		System.out.println("Status Code: " + response.getStatusCode());
		System.out.println("Response Body: " + response.getBody().asString());
	}

	@Given("I have valid cridentails {string} and {string}")
	public void i_have_valid_cridentails_and(String username, String password) {
		this.username = username;
		this.password = password;
	}

	@When("I have send authentication request")
	public void i_have_send_authentication_request() {
		response = given().auth().basic(username, password).get(APIConstants.BASE_URL);

	}

	@Then("I should get success code {int}")
	public void i_should_get_success_code(Integer statuscode) {
		response.then().statusCode(statuscode);
	}

	@Given("I have invalid cridentails {string} and {string}")
	public void i_have_invalid_cridentails_and(String username, String password) {
		this.username = username;
		this.password = password;
	}

	@Then("I should get response code {int}")
	public void i_should_get_response_code(Integer statuscode) {
		response.then().statusCode(statuscode);

	}
}
