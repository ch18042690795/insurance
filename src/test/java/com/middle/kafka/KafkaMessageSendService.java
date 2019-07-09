/*
package com.middle.kafka;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

*/
/**
 * @program: insurance
 * @description:
 * @author: Mr.Wang
 * @create: 2019-05-05 09:42
 **//*

@RestController
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {KafkaMessageSendService.class})
public class KafkaMessageSendService {
    private static final Logger LOG = LoggerFactory.getLogger(KafkaMessageSendService.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.app.topic.foo}")
    private String topic ="test";

    public static void main(String[] args) {
        KafkaMessageSendService k=new KafkaMessageSendService();
        k.send("test1");
    }
    public void send(String message){
        LOG.info("topic="+topic+",message="+message);
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, message);
        future.addCallback(success -> LOG.info("KafkaMessageProducer 发送消息成功！"),
                fail -> LOG.error("KafkaMessageProducer 发送消息失败！"));
    }
}
*/
