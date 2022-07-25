package com.example.demo.rabbitmq.listner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.rabbitmq.model.OrderDetail;

public class RabbitMQConsumerProduct {
	private static final Logger logger = LoggerFactory.getLogger(RabbitMQConsumerProduct.class);

	@RabbitListener(queues = "${rabbitmq.queue.product}")

	public ResponseEntity<Object> recievedMessage(OrderDetail order) {
		logger.info("Recieved Message From RabbitMQ- product: " + order);
		//System.out.println("Recieved Message From RabbitMQ:product " + order);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
}
