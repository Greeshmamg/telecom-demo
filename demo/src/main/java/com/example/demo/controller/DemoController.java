package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.services.RabbitMQSender;
import com.example.demo.services.ValidateOrderImpl;
import com.example.demo.utility.ObjectMapperUtility;

@RestController
public class DemoController {

	RestTemplate restTemplate = new RestTemplate();

	@Autowired
	HttpServletRequest httpServletRequest;

	@Autowired
	ObjectMapperUtility objectMapperUtility;

	@Autowired
	ValidateOrderImpl validateOrderImpl;
	@Autowired
	RabbitMQSender rabbitMQSender;

	@PostMapping(path = "/order")
	@ResponseBody
	public ResponseEntity<Object> createOrderRequest(@RequestBody(required = true) String order,@RequestParam("type") String type,
			HttpServletRequest request) {

		rabbitMQSender.send(objectMapperUtility.getDetails(order),type);
		return new ResponseEntity<>(HttpStatus.CREATED);

	}

}
