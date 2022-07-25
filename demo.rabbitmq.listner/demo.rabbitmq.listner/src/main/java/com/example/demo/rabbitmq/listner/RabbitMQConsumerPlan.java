package com.example.demo.rabbitmq.listner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.demo.rabbitmq.model.OrderDetail;

@Component
public class RabbitMQConsumerPlan {
	@Value("${rabbitmq.queue.product}")
	String exchange;
	
	 private static final Logger logger = LoggerFactory.getLogger(RabbitMQConsumerPlan.class);	
	 @RabbitListener(queues = "${rabbitmq.queue.plan}")
	public ResponseEntity<Object> recievedMessage(OrderDetail order) {
		logger.info("Recieved Message From RabbitMQ:plans " + order);
		
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
}
