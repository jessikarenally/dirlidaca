package com.kafka;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.DependsOn;
//import org.springframework.integration.IntegrationMessageHeaderAccessor;
//import org.springframework.integration.dsl.IntegrationFlow;
//import org.springframework.integration.dsl.kafka.Kafka;
//import org.springframework.integration.dsl.kafka.KafkaProducerMessageHandlerSpec;
//import org.springframework.integration.dsl.support.Consumer;
//import org.springframework.messaging.MessageChannel;
//import org.springframework.messaging.support.GenericMessage;
//
//@Configuration
//public class ProducerConfiguration {
//	   @Autowired
//	    private KafkaConfig kafkaConfig;
//
//	    private static final String OUTBOUND_ID = "outbound";
//
//	    private Log log = LogFactory.getLog(getClass());
//
//	    @Bean
//	    @DependsOn(OUTBOUND_ID)
//	    CommandLineRunner kickOff( 
//	           @Qualifier(OUTBOUND_ID + ".input") MessageChannel in) {
//	        return args -> {
//	            for (int i = 0; i < 1000; i++) {
//	                in.send(new GenericMessage<>("#" + i));
//	                log.info("sending message #" + i);
//	            }
//	        };
//	    }
//
//	    @Bean(name = OUTBOUND_ID)
//	    IntegrationFlow producer() {
//
//	      log.info("starting producer flow..");
//	      return flowDefinition -> {
//
//	        Consumer<KafkaProducerMessageHandlerSpec.ProducerMetadataSpec> spec =
//	          (KafkaProducerMessageHandlerSpec.ProducerMetadataSpec metadata)->
//	            metadata.async(true)
//	              .batchNumMessages(10)
//	              .valueClassType(String.class)
//	              .<String>valueEncoder(String::getBytes);
//
//	        KafkaProducerMessageHandlerSpec messageHandlerSpec =
//	          Kafka.outboundChannelAdapter(
//	               props -> props.put("queue.buffering.max.ms", "15000"))
//	            .messageKey(m -> m.getHeaders().get(IntegrationMessageHeaderAccessor.SEQUENCE_NUMBER))
//	            .addProducer(this.kafkaConfig.getTopic(), 
//	                this.kafkaConfig.getBrokerAddress(), spec);
//	        flowDefinition
//	            .handle(messageHandlerSpec);
//	      };
//	    }
//}
