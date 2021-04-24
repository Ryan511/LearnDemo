package com.ryan.learn.kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author zhongziqi
 * @date :2021/3/22 21:34
 * Desc:
 */
@Component
@Slf4j
public class CreateKafkaDataPrducer {
    @Resource(name = "kafkaCommonProducer")
    KafkaProducer<String, String> kafkaProducer;

    @Value("${kafka_topic}")
    private String topic;

    public void sendKafkaData(Integer num) {
        for (int i = 1; i <= num; i++) {
            //一直等待返回
            //kafkaProducer.send(new ProducerRecord<String, String>("message", "message"+i)).get()
//            if (i % 10 == 0) {
//                try {
//                    TimeUnit.SECONDS.sleep(5);
//                } catch (Exception e) {
//
//                }
//            }
//            kafkaProducer.send(new ProducerRecord<>(topic,))

//            ProducerRecord record=     new ProducerRecord<String, String>(topic, "message" + i);
//            ProducerRecord record = new ProducerRecord<String, String>(topic, "test-"+i, "testkv" + i);
            int par = i % 5;
            ProducerRecord record = new ProducerRecord<String, String>(topic, par, "test3-" + i, "testkv3" + i);
            //异步处理返回
            kafkaProducer.send(record, new Callback() {

                @Override
                public void onCompletion(RecordMetadata metadata, Exception e) {

                    if (e == null) {
                        //正常处理逻辑
                        log.info("The offset of the record we just sent is: " + metadata.offset());
                    } else {
//                        e.printStackTrace();
//                        if (e instanceof RetriableException) {
//                            log.error("处理可重试异常", e);
//                            //处理可重试异常
//                        } else {
//                            //处理不可重试异常
//                            log.error("处理不可重试异常", e);
//                        }
                        log.error("失败");
                    }
                }
            });
        }
    }
}
