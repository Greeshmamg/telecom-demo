package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DemoController {
	@Value("${redirect.url}")
	private String url;

	RestTemplate restTemplate = new RestTemplate();

	@GetMapping(path = "/getURL")
	public String getUrlValues() {
		String response = restTemplate.getForObject(url, String.class);
	return response;
	}

}
