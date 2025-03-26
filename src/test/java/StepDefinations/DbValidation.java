package StepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.DBUtils;

public class DbValidation {

	private String result;

	@Given("I connect to the database")

	public void i_connect_to_the_database() {
		DBUtils.DatabaseConnection();
	}

	@When("I execute the query {string}")
	public void i_execute_the_query(String string) {
		result = DBUtils.executeQuery(string);
	}

	@Then("I should see the query result")
	public void i_should_see_the_query_result() {
		if (!result.isEmpty()) {
			System.out.println("Query Result:\n" + result);
		} else {
			System.out.println("No records found.");
		}
		DBUtils.closeConnection();
	}

}
