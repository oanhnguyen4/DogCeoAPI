package stepsdefinition.ListAllDogsApi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import common.RequestUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckResponseWhenSendRequestSuccessfullySteps {
	String url, method;
	HttpResponse<String> response;
	
@Given("I have valid dogs URL and method")
public void i_have_valid_dogs_url_and_method(List<Map<String, String>> givenTable) {
	Map<String, String> row1 = givenTable.get(0);
	url = row1.get("URL");
	method = row1.get("Method");
}

@When("I send a dogs request")
public void i_send_a_dogs_request() {
	
	RequestUtils requestUtils = new RequestUtils();
	requestUtils.sendRequest(url, method, "");
}

@Then("I get a dogs status code and response")
public void i_get_a_dogs_status_code_and_response() {
	int actualStatusCode = response.statusCode();
    String responseBody = response.body();
    JSONParser parser = new JSONParser();
    try {
		JSONObject jsonObject = (JSONObject) parser.parse(responseBody);
		String actualMessage = jsonObject.get("message").toString();
		assertEquals(actualStatusCode, 200);
		assertTrue(!actualMessage.isEmpty());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


}
