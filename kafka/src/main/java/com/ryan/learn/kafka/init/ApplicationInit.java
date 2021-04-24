package com.ryan.learn.kafka.init;

import com.ryan.demo.kafka.producer.CreateKafkaDataPrducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author zhongziqi
 * @date :2021/3/22 21:36
 * Desc:
 */
@Component
@Slf4j
public class ApplicationInit implements CommandLineRunner {
    @Autowired
    private CreateKafkaDataPrducer createKafkaData;

    //    @Autowired
//    private NoAutoKafkaConsumer autoKafkaConsumer;
    @Override
    public void run(String... args) throws Exception {
        createKafkaData.sendKafkaData(10000000);
////        autoKafkaConsumer.consumer();
    }
}
