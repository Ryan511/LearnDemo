package com.ryan.learn.zookeeper;

import javafx.beans.binding.ObjectExpression;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class ZookeeperApplicationTests {
    static final Map<Integer, Object> stringObjectMap = new HashMap<>(10);

    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList<>(10);

        for (int i = 0; i < 20; i++) {
            arrayList.add(1);
            stringObjectMap.put(i, i);
        }

        System.out.println("arrayList = " + arrayList.size());
        System.out.println("stringObjectMap = " + stringObjectMap.size());
        try {
            System.out.println(1);
//            System.exit(1);
        } catch (Exception e) {
        } finally {
            System.exit(1);
            System.out.println("\"sadsa\" = " + "sadsa");
        }
    }

    @Test
    void contextLoads() {
    }

}
