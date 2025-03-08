package stepDefinitions;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import static org.hamcrest.Matchers.equalTo;

public class APIStepDefinitions {
    Response response;

    @Given("I send a GET request to {string}")
    public void i_send_a_get_request_to(String url) {
        response = RestAssured.get(url);
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("the response body should contain {string}")
    public void the_response_body_should_contain(String expectedValue) {
        response.then().body("message", equalTo(expectedValue)); // Check for the key "message" in your response
    }
}
