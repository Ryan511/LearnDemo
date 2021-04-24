package com.ryan.learn.kafka.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @author zhongziqi
 * @date :2021/3/22 21:18
 * Desc:
 */
@Configuration
@Slf4j
public class KafkaConfig {
    public static final String BOOT_STRAP_SERVER = "bootstrap.servers";

    public static final String ACK = "acks";

    public static final String RETRIES = "retries";

    public static final String BATCH_SIZE = "batch.size";

    public static final String LINGER_MS = "linger.ms";

    public static final String BUFFER_SIZE = "buffer.memory";

    public static final String KEY_SERIAL = "key.serializer";

    public static final String VALUE_SERIAL = "value.serializer";
    public static final String GROUP_ID = "group.id";
    public static final String ENABLE_AUTO_COMMIT = "enable.auto.commit";
    public static final String KEY_DESERIALIZER = "key.deserializer";
    public static final String VALUE_DESERIALIZER = "value.deserializer";

    @Value("${kafka_bootstrap_servers}")
    private String bootStrapServer;
    @Value("${kafka_acks}")
    private String acks;
    @Value("${kafka_retries}")
    private Integer retries;
    @Value("${kafka_batch_size}")
    private Integer batchSize;
    @Value("${kafka_buffer_memory}")
    private Integer bufferMemory;

    @Value("${kafka_linger_ms}")
    private Integer lingerMs;
    @Value("${kafka_key_serializer}")
    private String keySerial;
    @Value("${kafka_value_serializer}")
    private String valueSerial;

    @Value("${kafka_key_deserializer}")
    private String keyDeserial;
    @Value("${kafaka_value_deserializer}")
    private String valueDeserial;
    @Value("${consumer_group_id}")
    private String group;
    @Value("${enable_auto_commit}")
    private String enableAutoCommit;

    @Bean("kafkaProperties")
    public Properties getProperties() {
        Properties properties = new Properties();
        properties.put(BOOT_STRAP_SERVER, bootStrapServer);
        properties.put(ACK, acks);
        properties.put(BATCH_SIZE, batchSize);
        properties.put(LINGER_MS, lingerMs);
        properties.put(RETRIES, retries);
        properties.put(BUFFER_SIZE, bufferMemory);
        properties.put(KEY_SERIAL, keySerial);
        properties.put(VALUE_SERIAL, valueSerial);
        return properties;
    }

    @Bean("kafkaCommonProducer")
    public KafkaProducer<String, String> getKafkaProducer() {
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer(getProperties());
        return kafkaProducer;
    }

    @Bean("kafkaConsumerProperties")
    public Properties getConsumerProperties() {
        Properties properties = new Properties();
        properties.put(BOOT_STRAP_SERVER, bootStrapServer);
        properties.put(GROUP_ID, group);
        properties.put(ENABLE_AUTO_COMMIT, enableAutoCommit);
        properties.put(KEY_DESERIALIZER, keyDeserial);
        properties.put(VALUE_DESERIALIZER, valueDeserial);
        return properties;
    }

    @Bean("kafkaConsumer")
    public KafkaConsumer<String, String> getKafkaConsumer() {
        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(getConsumerProperties());
        return kafkaConsumer;
    }
}
