package com.ryan.learn.kafka.cousmer.multi;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

/**
 * @author jn
 * @date 2019/12/27
 * 多线程消费kafka  线程类
 */
public class ConsumerRunnable implements Runnable {
    private final KafkaConsumer<String, String> consumer;

    public ConsumerRunnable(String bootstrapServers, String groupId, String topic) {
        HashMap
        Properties props = new Properties();
        props.put("bootstrap.servers", bootstrapServers);
        props.put("group.id", groupId);
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("auto.offset.reset", "earliest");
        this.consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList(topic));
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
//            consumer.position()
            ConsumerRecords<String, String> records = consumer.poll(1000);
            for (ConsumerRecord<String, String> record : records) {
                i++;
                System.out.printf("thred = %d,i = %d,offset = %d, key = %s, value = %s%n", Thread.currentThread().getId(), i, record.offset(), record.key(), record.value());
            }
        }
    }
}
