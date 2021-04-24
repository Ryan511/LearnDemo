package com.ryan.learn.kafka.cousmer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author zhongziqi
 * @date :2021/3/23 23:23
 * Desc:
 */
@Component
@Slf4j
public class NoAutoKafkaConsumer {
    @Resource(name = "kafkaConsumer")
    KafkaConsumer<String, String> kafkaConsumer;
    @Value("${kafka_topic}")
    private String topic;

    public void consumer() {
        int i = 0;
        long statr = System.currentTimeMillis();
        try {
            kafkaConsumer.subscribe(Arrays.asList(topic));
            int batchCommit = 100;
            ArrayList<ConsumerRecord<String, String>> buffer = new ArrayList<>();
            while (true) {
                ConsumerRecords<String, String> records = kafkaConsumer.poll(1000);
                log.info("recorsds[{}]", records.count());
                for (ConsumerRecord<String, String> record : records) {
                    i++;
                    buffer.add(record);
                    log.info("offset = [{}], key = [{}], value = [{}]", record.offset(), record.key(), record.value());
                }
                if (buffer.size() >= batchCommit) {
                    log.info("本次提交[{}]", buffer.size());
                    kafkaConsumer.commitAsync();
                }
            }
        } catch (Exception e) {
            log.error("消费异常", e);
        } finally {
            log.info("total [{}] speed[{}]", i, System.currentTimeMillis() - statr);
        }
    }
}
