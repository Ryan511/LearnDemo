package com.ryan.learn.kafka.cousmer.single;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

/**
 * @author jn
 * @date 2019/12/27
 * 单线程消费kafka示例
 */
public class SingleApplication {
    public static void main(String[] args) {


        Properties props = new Properties();
        props.put("bootstrap.servers", "127.0.0.1:9091,127.0.0.1:9092,127.0.0.1:9093");
        props.put("group.id", "SingleApplication2");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        props.put("auto.offset.reset", "earliest");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("test-1"));
        try {
            int i = 0;
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(1000);
//                consumer.
//                records.
                for (ConsumerRecord<String, String> record : records) {
                    i++;
                    System.out.printf("i = %d,offset = %d, key = %s, value = %s%n", i, record.offset(), record.key(), record.value());
                }

            }
        } finally {
            consumer.close();
        }
    }
}
