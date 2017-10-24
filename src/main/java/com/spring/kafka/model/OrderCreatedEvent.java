package com.spring.kafka.model;

public class OrderCreatedEvent {
	private String eventId;
	private String orderId;
	
	public OrderCreatedEvent(){
	}
	
	public OrderCreatedEvent(String eventId, String orderId){
		this.eventId = eventId;
		this.orderId = orderId;
	}
	
	public void setEventId(String eventId){
		this.eventId = eventId;
	}
	
	public String getEventId(){
		return this.eventId;
	}
	
	public void setOrderId(String orderId){
		this.orderId = orderId;
	}
	
	public String getOrderId(){
		return this.orderId;
	}

	@Override
	public String toString() {
		return "OrderCreatedEvent [eventId=" + eventId + ", orderId=" + orderId + "]";
	}
	
}