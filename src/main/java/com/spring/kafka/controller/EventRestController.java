package com.spring.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.kafka.model.OrderCreatedEvent;
import com.spring.kafka.services.KafkaProducer;
import com.spring.kafka.storage.EventStorage;

@RestController
@RequestMapping(value="/spring-kafka")
public class EventRestController {
	
	@Autowired
	KafkaProducer producer;
	
	@Autowired
	EventStorage storage;
	
	@GetMapping(value="/producer")
	public String producer(@RequestParam("event-id")String eventId, 
			@RequestParam("order-id")String orderId){
		OrderCreatedEvent event = new OrderCreatedEvent(eventId, orderId);
		producer.send(event);
		return "Done";
	}
	
	@GetMapping(value="/consumer")
	public String getAllRecievedMessage(){
		String messages = storage.toString();
		storage.clear();
		return messages;
	}
}
