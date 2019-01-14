package com.frank.zheng.crash_process.config;

import com.frank.zheng.crash_process.model.SdkLogItem;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {
    @Value("${kafka.servers}")
    private String servers;

    public ConsumerFactory<String, SdkLogItem> sdkLogItemConsumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, servers);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "sdkLogItem");
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), new JsonDeserializer<>(SdkLogItem.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, SdkLogItem> sdkLogItemKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, SdkLogItem> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(sdkLogItemConsumerFactory());
        return factory;
    }
}
