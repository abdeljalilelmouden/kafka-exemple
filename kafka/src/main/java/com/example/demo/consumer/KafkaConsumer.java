package com.example.demo.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.demo.entity.FormationEntity;

@Service
public class KafkaConsumer {
	
	
	@KafkaListener(topics = "myTopic", groupId = "myGroupe")
	public void consumerMessage(String message) {
		
		System.out.println("MESSAGE ================= " + message);
	}
	
	
	@KafkaListener(topics = "myTopic", groupId = "myGroupe")
	public void consumerMessageJson(FormationEntity formationEntity) {
		
		System.out.println("MESSAGE ================= " + formationEntity.getTitre());
	}

}
