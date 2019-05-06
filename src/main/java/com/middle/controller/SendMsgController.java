package com.middle.controller;

import com.middle.controller.kafka.KafKaCustomrProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: insurance
 * @description:
 * @author: Mr.Wang
 * @create: 2019-05-05 10:42
 **/
@RestController
public class SendMsgController {

    @Autowired
    private KafKaCustomrProducer kafKaCustomrProducer;
    @Autowired
    private KafkaTemplate kafkaTemplate;
    @Value("${spring.kafka.app.topic.foo}")
    private String topic;
    @Value("${spring.kafka.app.topic.foo1}")
    private String topic1;
    @Value("${spring.kafka.app.topic.foo2}")
    private String topic2;
    @Value("${spring.kafka.app.topic.foo3}")
    private String topic3;
    @Value("${spring.kafka.app.topic.foo4}")
    private String topic4;
    @Value("${spring.kafka.app.topic.foo5}")
    private String topic5;
    @Value("${spring.kafka.app.topic.foo6}")
    private String topic6;
    @Value("${spring.kafka.app.topic.foo7}")
    private String topic7;
    @Value("${spring.kafka.app.topic.foo8}")
    private String topic8;
    @Value("${spring.kafka.app.topic.foo9}")
    private String topic9;
    /***
     * 发送消息体为基本类型的消息
     */
    @GetMapping("sendSimple")
    public void sendSimple() {
        kafKaCustomrProducer.sendMessage(topic, "{\n" +
                "\t\"head\": {\n" +
                "\t\t\"appId\":\"\",\n" +
                "\t\t\"requestId\":\"1c431e11c4374b7ca4eb5497d5197132\"\n" +
                "\t},\n" +
                "\t\"body\": {\"datas\":\n" +
                "\t[{\n" +
                "\t\t\"value\":{\n" +
                "\t\t\"pkid00\": \"6922adf8958a47ccb13acc4d8fb29eef\",\n" +
                "\t\t\"xmbh00\": \"21330802017000\",\n" +
                "\t\t\"xmmc00\": \"三大目录\",\n" +
                "\t\t\"yplb00\": \"三大目录类别\",\n" +
                "\t\t\"fpxmbh\": \"三大目录类型\",\n" +
                "\t\t\"ybfyfw\": \"1000\",\n" +
                "\t\t\"xmdw00\": \"单位\",\n" +
                "\t\t\"xmgg00\": \"规格\",\n" +
                "\t\t\"jx0000\": \"类型\"\n" +
                "\t\t}\n" +
                "\t}]}\n" +
                "}");
        kafKaCustomrProducer.sendMessage(topic1,"{\n" +
                "\t\"head\": {\n" +
                "\t\t\"appId\": \"\",\n" +
                "\t\t\"requestId\": \"2e6fa451a9a94894af7196c9356907f4\"\n" +
                "\t},\n" +
                "\t\"body\": {\n" +
                "\t\t\"datas\": [{\n" +
                "\t\t\t\"value\": {\n" +
                "\t\t\t\t\"fwwdbh\": \"512321321\",\n" +
                "\t\t\t\t\"fwwdmc\": \"医疗机构名称\",\n" +
                "\t\t\t\t\"wdjbbh\": \"医疗机构等级\",\n" +
                "\t\t\t\t\"qsrq00\": \"2017-3-12 12:12:10\",\n" +
                "\t\t\t\t\"jzrq00\": \"2017-9-12 12:12:10\",\n" +
                "\t\t\t\t\"lxren0\": \"联系人\",\n" +
                "\t\t\t\t\"lxdhua\": \"111111\",\n" +
                "\t\t\t\t\"lxsji0\": \"222222\",\n" +
                "\t\t\t\t\"wddz00\": \"通讯地址\",\n" +
                "\t\t\t\t\"yljgxz\": \"医疗机构性质（预留）\",\n" +
                "\t\t\t\t\"sfddyljg\": \"是否定点医疗机构\",\n" +
                "\t\t\t\t\"yljgylxz\": \"医疗机构盈利性质（预留）\",\n" +
                "\t\t\t\t\"yljgxzjb\": \"医疗机构行政级别（预留）\",\n" +
                "\t\t\t\t\"yljgxzgsd\": \"医疗机构行政归属地\"\n" +
                "\t\t\t}\n" +
                "\t\t}]\n" +
                "\t}\n" +
                "}");
    }
}

