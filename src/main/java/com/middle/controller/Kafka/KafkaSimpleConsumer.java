package com.middle.controller.Kafka;

import com.middle.controller.webService.printClient;
import com.middle.entity.*;
import com.middle.service.InsertDataService;
import com.middle.service.UploadDataService;
import com.middle.service.impl.InsertDataServiceImpl;
import com.middle.service.impl.UploadDataServiceImpl;
import com.middle.utils.Array2List;
import com.middle.utils.FactoryUtils;
import com.middle.utils.SpringContextUtil;
import com.middle.utils.mapToObject;


import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.serializer.StringDecoder;
import kafka.utils.VerifiableProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;


@RestController
public class KafkaSimpleConsumer {
    @Autowired
    InsertDataServiceImpl insertDataService;
    @Autowired
    UploadDataServiceImpl uploadDataService;
    @Value("${spring.kafka.app.topic.foo}")
    private String topic = "780409b81da84934b8f696c15e1f1c83";
    @Value("${spring.kafka.app.topic.foo1}")
    private String topic1 = "a08b3d63ef774285a9553661e61eadcd";
    @Value("${spring.kafka.app.topic.foo2}")
    private String topic2 = "8758d8c08ef06048e0530a0102136048-fabbfafa7f1943218820781d61a683a1";
    @Value("${spring.kafka.app.topic.foo3}")
    private String topic3 = "9c1baca06c3f47e08d80b6c163cb49d7-fabbfafa7f1943218820781d61a683a1";
    @Value("${spring.kafka.app.topic.foo4}")
    private String topic4 = "c100d3a342ba4b6997f63458e27d3531-fabbfafa7f1943218820781d61a683a1";
    @Value("${spring.kafka.app.topic.foo5}")
    private String topic5 = "668ae9add7f249e490055240cae5e9ce-fabbfafa7f1943218820781d61a683a1";
    @Value("${spring.kafka.app.topic.foo6}")
    private String topic6 = "91f30ef49a6c4cea9452d13bef00f71b";
    @Value("${spring.kafka.app.topic.foo7}")
    private String topic7 = "d67e3b6fdd17424c806ede6df6800b51";
    @Value("${spring.kafka.app.topic.foo8}")
    private String topic8 = "c5dde726063e42e98f6a20b3bb61d582";

@RequestMapping("/aaa")
    public void insertMessage(String message, String CertainTopic) {
    HashMap<String, Object> maps = Array2List.fromJson2Map(message);
    if (CertainTopic.equals(topic)) {
        try{
            IsSdml isSdml = mapToObject.setObjectsdml(maps);
            String result = insertDataService.insertData(isSdml);
        }catch (Exception e){
            e.getMessage();
        }
    }
    if (CertainTopic.equals(topic1)) {
        try {
            Islljg islljg = mapToObject.setObjectyljg(maps);
            String result = insertDataService.insertData(islljg);
        }catch (Exception e){
            e.getMessage();
        }
    }
    if (CertainTopic.equals(topic2)) {
        try{
            IsCbrxx isCbrxx = mapToObject.setObjectCbrxx(maps);
            String result = insertDataService.insertData(isCbrxx);
        }
        catch (Exception e){
            e.getMessage();
        }
    }
    if (CertainTopic.equals(topic3)) {
        try{
            IsDbsp islDbsp = mapToObject.setObjectDbsp(maps);

            String result = insertDataService.insertData(islDbsp);
        }
        catch (Exception e){
            e.getMessage();
        }
    }
    if (CertainTopic.equals(topic4)) {
        try {
            IsZybc isZybc = mapToObject.setObjectZybc(maps);
            String result = insertDataService.insertData(isZybc);
        }
        catch(Exception e){
            System.out.println( e.getMessage());
        }
    }
    if (CertainTopic.equals(topic5)) {
        try {
            IsDbbcywzt isDbbcywzt = mapToObject.setObjectDbbcywzt(maps);
            String result = insertDataService.insertData(isDbbcywzt);
        }catch (Exception e){
            e.getMessage();
        }

    }
}
}

