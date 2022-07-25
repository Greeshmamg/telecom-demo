package com.example.demo.services;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.example.demo.rabbitmq.model.OrderDetail;
@Configuration
public class RabbitMQSender {
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	@Value("${rabbitmq.exchange}")
	private String exchange;
	
	@Value("${rabbitmq.routingkey}")
	private String routingkey;	
	
	public void send(OrderDetail order,String type) {
		MessageProperties messageProperties = new MessageProperties();
		messageProperties.setHeader("type", type);
		MessageConverter messageConverter = new SimpleMessageConverter();
		Message message = messageConverter.toMessage(order, messageProperties);
		rabbitTemplate.convertAndSend(exchange, "", message);
	    
	}
}
