package com.nechackathon.InformationServices;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemp {

	@Bean
	public RestTemplate restOperations() {
		return new RestTemplate();
	}
}
