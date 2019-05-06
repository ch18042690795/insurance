package com.middle.controller.kafka;

import com.middle.entity.IsSdml;
import com.middle.entity.Islljg;
import com.middle.service.InsertDataService;
import com.middle.service.UploadDataService;
import com.middle.utils.Array2List;
import com.middle.utils.mapToObject;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.internals.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @program: insurance
 * @description:
 * @author: Mr.Wang
 * @create: 2019-05-05 10:35
 **/
@Component
public class KafkaSimpleConsumer {
    @Autowired
    InsertDataService insertDataService;
    @Autowired
    UploadDataService uploadDataService;

    // 简单消费者
    @KafkaListener(id = "consumer1-0", groupId = "simpleGroup", topics = {"${spring.kafka.app.topic.foo}"})
    public void consumer1_0(ConsumerRecord<String, Object> record) {
        HashMap<String, Object> maps = Array2List.fromJson2Map(record.value().toString());
        //传入对象中
        IsSdml isSdml = mapToObject.setObjectsdml(maps);
        //入库
        String resultid = insertDataService.insertData(isSdml);
        if (resultid != null) {
            //取数
            String result = uploadDataService.getData(isSdml);
            if (result.equals("ok")) {
                System.out.println("上传成功");
            }else {

            }

        }
        System.out.println("消费者收到消息:" + maps);
        /*
         * 如果需要手工提交异步 consumer.commitSync();
         * 手工同步提交 consumer.commitAsync()
         */
    }

    // 分组1 中的消费者1
    @KafkaListener(id = "consumer1-1", groupId = "simpleGroup", topics = {"${spring.kafka.app.topic.foo1}"})
    public void consumer1_1(ConsumerRecord<String, Object> record) {
        HashMap<String, Object> maps = Array2List.fromJson2Map(record.value().toString());
        //传入对象中
      Islljg islljg= mapToObject.setObjectyljg(maps);
        //入库
        String resultid = insertDataService.insertData(islljg);
        if (resultid != null) {
            //取数
            String result = uploadDataService.getData(islljg);
            if (result.equals("ok")) {
                System.out.println("上传成功");
            }else{

            }

        }
        System.out.println("consumer1-1 收到消息:" + record.value());
    }

    // 分组1 中的消费者2
    @KafkaListener(id = "consumer1-2", groupId = "simpleGroup", topics = {"${spring.kafka.app.topic.foo2}"})
    public void consumer1_2(ConsumerRecord<String, Object> record) {


        System.out.println("consumer1-2 收到消息:" + record.value());
    }

    // 分组1 中的消费者3
    @KafkaListener(id = "consumer1-3", groupId = "simpleGroup", topics = {"${spring.kafka.app.topic.foo3}"})
    public void consumer1_3(ConsumerRecord<String, Object> record) {
        System.out.println("consumer1-3 收到消息:" + record.value());
    }

    // 分组2 中的消费者
    @KafkaListener(id = "consumer2-1", groupId = "group2", topics = {"${spring.kafka.app.topic.foo4}"})
    public void consumer2_1(ConsumerRecord<String, Object> record) {
        System.err.println("consumer2-1 收到消息:" + record.value());
    }

}

