/*
package com.middle.kafka;

import com.InsuranceApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;

*/
/**
 * @program: insurance
 * @description:
 * @author: Mr.Wang
 * @create: 2019-05-05 09:56
 **//*

@SpringBootApplication
@EnableConfigurationProperties
public class KafkaMessageConsumer {


    public static void main(String[] args) {
        SpringApplication.run(InsuranceApplication.class, args);
    }

    private static final Logger LOG = LoggerFactory.getLogger(KafkaMessageConsumer.class);

    @KafkaListener(topics = {"${kafka.app.topic.foo}"})
    public void receive(@Payload String message, @Headers MessageHeaders headers) {
        LOG.info("KafkaMessageConsumer 接收到消息：" + message);
        headers.keySet().forEach(key -> LOG.info("{}: {}", key, headers.get(key)));
    }
}
*/
