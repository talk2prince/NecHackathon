package com.nechackathon.InformationServices;

import java.io.IOException;

import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class DataService {
	String name;
	
	//we will put api call here
	@Autowired
	RestTemplate restOperations;
	public JSONObject getData(String dataType) {
		
		//Traffic Data
		if(dataType.equals("traffic")) {
			try {
			JSONObject result = restOperations.getForObject("https://traffic.ls.hereapi.com/traffic/6.3/incidents/xml/8/134/86?apiKey=kvDR3kyyyV_nESzOkPe1SEXzAZdpwEN7aLMTPXTe0b0",JSONObject.class);
			return result;
			} catch(RestClientException e) {
				System.out.println("Error");
			}
		}
		return null;
	}
}
