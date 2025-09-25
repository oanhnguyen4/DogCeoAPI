package common;

import java.net.http.HttpResponse;

public class RequestUtils {
     public HttpResponse<String> sendRequest(String url, String method, String requestBody) {
		    HttpResponse<String> response = null;
		    Request request = new Request();
		    if (method.equalsIgnoreCase(HttpMethod.GET.toString())) {
		    	response = request.sendGetRequest(url);
		    	System.out.println("Check response");
		    }
		    return response;
		    
	}
}
