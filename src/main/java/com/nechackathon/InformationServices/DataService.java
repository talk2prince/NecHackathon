package com.nechackathon.InformationServices;

import java.io.IOException;

import org.codehaus.jettison.json.JSONObject;
import org.codehaus.jettison.json.JSONString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class DataService {
	String name;
	
	@Value("${api.key}")
	private String api_key;
	
	//we will put api call here
	@Autowired
	RestTemplate restOperations;
	public JSONString getData(String dataType) {
		
		//Traffic Data
		if(dataType.equals("traffic")) {
			try {
			JSONString result = restOperations.getForObject("https://traffic.ls.hereapi.com/traffic/6.3/incidents/xml/8/134/86"+
																"?apiKey=" + api_key, JSONString.class);
			return result;
			} catch(RestClientException e) {
				System.out.println("Error");
			}
		}
		return null;
	}
}
