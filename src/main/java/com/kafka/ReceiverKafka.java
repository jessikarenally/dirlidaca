package com.kafka;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.PollableChannel;

import com.Application;

public class ReceiverKafka {
	
	/**
	 * Recupera as mensagens salvas no Kafka
	 */
 	public void receiveFromKafka() {
 		ConfigurableApplicationContext context = 
 				new SpringApplicationBuilder(Application.class)
 			.web(false)
 			.run();
 		
 		PollableChannel fromKafka = context.getBean("received", PollableChannel.class);
 		Message<?> received = fromKafka.receive(10000);
 		while (received != null) {
 			System.out.println(received);
 			received = fromKafka.receive(10000);
 		}
 		context.close();
 	}
}
