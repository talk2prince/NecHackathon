package com.nechackathon.InformationServices;

import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.apache.http.HttpHeaders;
import org.apache.http.client.ResponseHandler;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


@Service
public class DataService {
	public static final Logger s_log = LogManager.getLogManager().getLogger("DataService");
	
	@Value("${api.key}")
	private String api_key;
	final String  TRAFFIC_URL = "https://traffic.ls.hereapi.com/traffic/6.3/incidents/xml/8/134/86";
	
	@Autowired
	RestTemplate restOperations;
	
	//put api call here
	public String getData(String dataType) {
		
		CloseableHttpClient client = HttpClients.custom().build();
        ResponseHandler<String> responseHandler=new BasicResponseHandler();
        
		//Traffic Data
		if(dataType.equals("traffic")) {
			try {
				// Make the Request
				HttpUriRequest request = (HttpUriRequest) RequestBuilder.get().setUri(TRAFFIC_URL)
						.setHeader(HttpHeaders.CONTENT_TYPE,"application/json").addParameter("apiKey", api_key).build();
				
				// Execute HTTP Get Request
		        String responseBody = client.execute(request, responseHandler);
		        return responseBody;

			} catch(RestClientException | IOException e) {
				s_log.info(e.getMessage());
			}
				
		}
		return null;
	}
}
