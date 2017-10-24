package com.spring.kafka.storage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.kafka.model.OrderCreatedEvent;

@Component
public class EventStorage {
	
	private List<OrderCreatedEvent> storage = new ArrayList<OrderCreatedEvent>();
	
	public void put(OrderCreatedEvent event){
		storage.add(event);
	}
	
	public String toString(){
		StringBuffer info = new StringBuffer();
		storage.forEach(event->info.append(event.toString()).append("<br/>"));
		return info.toString();
	}
	
	public void clear(){
		storage.clear();
	}
}
