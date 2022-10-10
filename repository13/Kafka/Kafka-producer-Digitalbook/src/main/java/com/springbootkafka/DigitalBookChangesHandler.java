package com.springbootkafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;

public class DigitalBookChangesHandler implements EventHandler {
	
	private static final Logger LOGGER=LoggerFactory.getLogger("DigitalBookChangesHandler");
	private KafkaTemplate<String,String> kafkatemplate;
	private String topic;

	public DigitalBookChangesHandler(KafkaTemplate<String, String> kafkatemplate, String topic) {
		super();
		this.kafkatemplate = kafkatemplate;
		this.topic = topic;
	}

	@Override
	public void onOpen() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClosed() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMessage(String event, MessageEvent messageEvent) throws Exception {
		LOGGER.info(String.format("ËVENT DATA--> %S", messageEvent.getData()));
		
		kafkatemplate.send(topic, messageEvent.getData());
		
	}

	@Override
	public void onComment(String comment) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onError(Throwable t) {
		// TODO Auto-generated method stub
		
	}

}
