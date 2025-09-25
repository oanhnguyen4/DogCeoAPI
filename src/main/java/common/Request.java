package common;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Request {
	HttpRequest request;
	HttpResponse<String> response;
	
	
    public Request() {
		request = null;
	}

	public HttpResponse<String> sendGetRequest(String url) {
    	try {
			HttpRequest request = HttpRequest.newBuilder().uri(new URI(url)).GET().build();
			response =  HttpClient.newHttpClient().send(request, BodyHandlers.ofString());
		} catch (Exception e) {
			System.out.println("read response data fail");
			e.printStackTrace();
		}
		return this.response;
	}
 
}
