package com.ryan.learn.kafka.cousmer.multi;

/**
 * @author jn
 * @date 2019/12/27
 * 多线程消费kafka 执行类
 */
public class MultiApplication {

    public static void main(String[] args) {

        String bootstrapServers = "127.0.0.1:9091,127.0.0.1:9092,127.0.0.1:9093";
        String groupId = "MultiApplication2";
        String topic = "test-3";
        int consumerNum = 6;
        ConsumerGroup cg = new ConsumerGroup(consumerNum, bootstrapServers, groupId, topic);
        cg.execute();
    }
}
