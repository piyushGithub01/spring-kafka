package com.spring.kafka.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.spring.kafka.model.OrderCreatedEvent;

@Service
public class KafkaProducer {
	@Autowired
	private KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;
	
	@Value("${kafka.topic}")
	String kafkaTopic = "kafka-test";
	
	public void send(OrderCreatedEvent event) {
	    System.out.println("sending data=" + event);
	    kafkaTemplate.send(kafkaTopic, event);
	}
}
