package com.kafka;
/**
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.integration.IntegrationMessageHeaderAccessor;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.SourcePollingChannelAdapterSpec;
import org.springframework.integration.dsl.kafka.Kafka;
import org.springframework.integration.dsl.kafka.KafkaHighLevelConsumerMessageSourceSpec;
import org.springframework.integration.dsl.kafka.KafkaProducerMessageHandlerSpec;
import org.springframework.integration.dsl.support.Consumer;
import org.springframework.integration.kafka.support.ZookeeperConnect;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

public class ConsumerConfiguration {
	@Autowired
    private KafkaConfig kafkaConfig;

    private Log log = LogFactory.getLog(getClass());

    @Bean
    IntegrationFlow consumer() {

      log.info("starting consumer..");

      KafkaHighLevelConsumerMessageSourceSpec messageSourceSpec = Kafka.inboundChannelAdapter(
          new ZookeeperConnect(this.kafkaConfig.getZookeeperAddress()))
            .consumerProperties(props ->
                props.put("auto.offset.reset", "smallest")
                     .put("auto.commit.interval.ms", "100"))
            .addConsumer("myGroup", metadata -> metadata.consumerTimeout(100)
              .topicStreamMap(m -> m.put(this.kafkaConfig.getTopic(), 1))
              .maxMessages(10)
              .valueDecoder(String::new));

      Consumer<SourcePollingChannelAdapterSpec> endpointConfigurer = e -> e.poller(p -> p.fixedDelay(100));

      return IntegrationFlows
        .from(messageSourceSpec, endpointConfigurer)
        .<Map<String, List<String>>>handle((payload, headers) -> {
            payload.entrySet().forEach(e -> log.info(e.getKey() + '=' + e.getValue()));
            return null;
        })
        .get();
    }
}*/