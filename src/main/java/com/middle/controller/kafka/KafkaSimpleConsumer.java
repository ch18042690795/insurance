package com.middle.controller.kafka;

import com.middle.entity.*;
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

    // 三大目录消费主题
    @KafkaListener(id = "consumer1-0", groupId = "simpleGroup", topics = {"${spring.kafka.app.topic.foo}"})
    public synchronized void consumer1_0(ConsumerRecord<String, Object> record) {
        HashMap<String, Object> maps = Array2List.fromJson2Map(record.value().toString());
        //传入对象中
        IsSdml isSdml = mapToObject.setObjectsdml(maps);
        //入库
        String resultid = insertDataService.insertData(isSdml);
        if (resultid != null) {
            //取数
            uploadDataService.getData(isSdml);
            System.out.println("消费者收到消息:" + maps);

        }

        /*
         * 如果需要手工提交异步 consumer.commitSync();
         * 手工同步提交 consumer.commitAsync()
         */
    }

    // 医疗机构消费主题
    @KafkaListener(id = "consumer1-1", groupId = "simpleGroup", topics = {"${spring.kafka.app.topic.foo1}"})
    public synchronized void consumer1_1(ConsumerRecord<String, Object> record) {
        HashMap<String, Object> maps = Array2List.fromJson2Map(record.value().toString());
        //传入对象中
        Islljg islljg = mapToObject.setObjectyljg(maps);
        //入库
        String resultid = insertDataService.insertData(islljg);
        if (resultid != null) {
            //取数
            uploadDataService.getData(islljg);
            System.out.println("consumer1-1 收到消息:" + record.value());

        }

    }

    // 参保人消费主题
    @KafkaListener(id = "consumer1-2", groupId = "simpleGroup", topics = {"${spring.kafka.app.topic.foo2}"})
    public synchronized void consumer1_2(ConsumerRecord<String, Object> record) {
        HashMap<String, Object> maps = Array2List.fromJson2Map(record.value().toString());
        //传入对象中
        IsCbrxx isCbrxx = mapToObject.setObjectCbrxx(maps);
        //入库
        String resultid = insertDataService.insertData(isCbrxx);

            //取数
            uploadDataService.getData(isCbrxx);
            System.out.println("consumer1-2 收到消息:" + record.value());


    }

    // 大病索赔
    @KafkaListener(id = "consumer1-3", groupId = "simpleGroup", topics = {"${spring.kafka.app.topic.foo3}"})
    public synchronized void consumer1_3(ConsumerRecord<String, Object> record) {
        HashMap<String, Object> maps = Array2List.fromJson2Map(record.value().toString());
        //传入对象中
        IsDbsp islDbsp = mapToObject.setObjectDbsp(maps);
        //入库
        String resultid = insertDataService.insertData(islDbsp);
        if (resultid != null) {
            //取数
           uploadDataService.getData(islDbsp);
         /*   if (result.equals("ok")) {
                System.out.println("上传成功");
            } else {
            }*/
            System.out.println("consumer1-3 收到消息:" + record.value());
        }

    }

  // 住院补偿
    @KafkaListener(id = "consumer1-4", groupId = "simpleGroup", topics = {"${spring.kafka.app.topic.foo4}"})
    public synchronized void consumer1_4(ConsumerRecord<String, Object> record) {
        HashMap<String, Object> maps = Array2List.fromJson2Map(record.value().toString());
        //传入对象中
        IsZybc isZybc = mapToObject.setObjectZybc(maps);
        //入库
        String resultid = insertDataService.insertData(isZybc);
        if (resultid != null) {
            //取数
           uploadDataService.getData(isZybc);
            System.err.println("consumer1-4 收到消息:" + record.value());
        }

    }

     // 大病补偿业务状态
    @KafkaListener(id = "consumer1-5", groupId = "simpleGroup", topics = {"${spring.kafka.app.topic.foo5}"})
    public synchronized void consumer1_5(ConsumerRecord<String, Object> record) {
        HashMap<String, Object> maps = Array2List.fromJson2Map(record.value().toString());
        //传入对象中
        IsDbbcywzt isDbbcywzt = mapToObject.setObjectDbbcywzt(maps);
        //入库
        String resultid = insertDataService.insertData(isDbbcywzt);

      if (resultid != null) {
            //取数
             uploadDataService.getData(isDbbcywzt);
          System.err.println("consumer1-5 收到消息:" + record.value());

        }

    }


    // 参保信息获取接口主题
    @KafkaListener(id = "consumer1-6", groupId = "simpleGroup", topics = {"${spring.kafka.app.topic.foo6}"})
    public synchronized void consumer1_6(ConsumerRecord<String, Object> record) {
        HashMap<String, Object> maps = Array2List.fromJson2Map(record.value().toString());
        //传入对象中
        IsCbxxhq isCbxxhq = mapToObject.setObjectCbxxhq(maps);
        //入库
        String resultid = insertDataService.insertData(isCbxxhq);
        if (resultid != null) {
            //取数
            uploadDataService.getData(isCbxxhq);
            System.err.println("consumer1-6 收到消息:" + record.value());

        }

    }

   // 理赔状态接口主题
    @KafkaListener(id = "consumer1-7", groupId = "simpleGroup", topics = {"${spring.kafka.app.topic.foo7}"})
    public synchronized void consumer1_7(ConsumerRecord<String, Object> record) {
        HashMap<String, Object> maps = Array2List.fromJson2Map(record.value().toString());
        //传入对象中
        Islpzt islpzt = mapToObject.setObjectIslpzt(maps);
        //入库
        String resultid = insertDataService.insertData(islpzt);
        if (resultid != null) {
            //取数
          uploadDataService.getData(islpzt);
            System.err.println("consumer1-7 收到消息:" + record.value());

        }

    }

     // 大病补偿业务状态查询主题
    @KafkaListener(id = "consumer1-8", groupId = "simpleGroup", topics = {"${spring.kafka.app.topic.foo8}"})
    public synchronized void consumer1_8(ConsumerRecord<String, Object> record) {
        HashMap<String, Object> maps = Array2List.fromJson2Map(record.value().toString());
        //传入对象中
        IsDbbcywztcx isDbbcywztcx = mapToObject.setObjectIsDbbcywztcx(maps);
        //入库
        String resultid = insertDataService.insertData(isDbbcywztcx);
        if (resultid != null) {
            //取数
            uploadDataService.getData(isDbbcywztcx);
            System.err.println("consumer1-8 收到消息:" + record.value());

        }

    }

}

