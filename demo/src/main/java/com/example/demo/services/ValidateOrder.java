package com.example.demo.services;

import com.example.demo.rabbitmq.model.OrderDetail;

public interface ValidateOrder {
		 abstract void validateOrderDetails(OrderDetail detail);
	}
