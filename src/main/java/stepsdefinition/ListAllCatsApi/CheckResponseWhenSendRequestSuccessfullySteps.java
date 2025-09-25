package stepsdefinition.ListAllCatsApi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import common.RequestUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckResponseWhenSendRequestSuccessfullySteps {
	String url, method;
	HttpResponse<String> response;
	
	@Given("I have valid cats URL and method")
	public void i_have_valid_cats_url_and_method() {
		url = "https://api.thecatapi.com/v1/breeds";
	    
	}

	@When("I send a cats request")
	public void i_send_a_cats_request() {
		RequestUtils requestUtils = new RequestUtils();
		requestUtils.sendRequest(url, method, "");
	   
	}

	@Then("I get a cats status code and response")
	public void i_get_a_cats_status_code_and_response() {
		int actualStatusCode = response.statusCode();
	    String responseBody = response.body();
	    JSONParser parser = new JSONParser();
	    try {
	    	JSONArray jsonArray = (JSONArray) parser.parse(responseBody);
	    	assertEquals(actualStatusCode, 200);
	        assertTrue(!jsonArray.isEmpty());
	        
	        JSONObject firstBreed = (JSONObject) jsonArray.get(0);
	        System.out.println("First breed name: " + firstBreed.get("name"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}


}
