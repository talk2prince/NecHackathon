package com.nechackathon.InformationServices;

import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DataController {
	
	@Autowired
	DataService dataService;
	
	@GetMapping("/rest/data/{dataType}")
	public JSONObject getSpecificData(@PathVariable("dataType") String dataType) {
		return dataService.getData(dataType);
	}
}
