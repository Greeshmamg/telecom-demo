package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	@Value("${redirect.url}")
	private String url;
	
	@GetMapping(path="/getURL")
	public String getUrlValues() {
		
		return url;
	}

}
