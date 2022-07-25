package com.example.demo.services;

import org.springframework.context.annotation.Configuration;

import com.example.demo.rabbitmq.model.OrderDetail;
@Configuration
public class ValidateOrderImpl implements ValidateOrder {

	@Override
	public void validateOrderDetails(OrderDetail detail) {
		System.out.println("-------------------");
		System.out.println(detail.toString());
	}
}