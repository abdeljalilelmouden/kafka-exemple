package com.example.demo.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IFormationRepository;


@Service
public class KafkaProducer {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Autowired
	private KafkaTemplate<Object, String> kafkaTemplateJson;
	
	@Autowired
	private IFormationRepository formationRepository;
	
	
	public void sendMessageToTopic() {
		
		kafkaTemplate.send("myTopic",  " this title from kafka with spring boot application " + formationRepository.findById(1L).get().getTitre());
		
	}
	
	public void sendMessageJsonToTopic(Object object) {
	
		org.springframework.messaging.Message<Object> message = MessageBuilder.withPayload(object).setHeader(KafkaHeaders.TOPIC, "myTopic").build();
		
		kafkaTemplateJson.send(message);
	}
}