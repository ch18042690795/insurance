package com.middle.controller.Kafka;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.middle.controller.webService.printClient;
import com.middle.entity.*;
import com.middle.service.impl.InsertDataServiceImpl;
import com.middle.service.impl.UploadDataServiceImpl;
import com.middle.utils.Array2List;
import com.middle.utils.mapToObject;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

import kafka.message.MessageAndMetadata;
import kafka.serializer.StringDecoder;
import kafka.utils.VerifiableProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/**
 * @program: insurance
 * @description:
 * @author: Mr.Wang
 * @create: 2019-06-02 20:48
 **/

@Component//这个注解可以让项目启动后,就执行这个类,要实现CommandLineRunner接口
@Order(value = 1)
public class KafkaConfiguration implements CommandLineRunner {
    @Value("${spring.kafka.app.topic.foo}")
    private String topic ="780409b81da84934b8f696c15e1f1c83";
    @Value("${spring.kafka.app.topic.foo1}")
    private String topic1="a08b3d63ef774285a9553661e61eadcd";
    @Value("${spring.kafka.app.topic.foo2}")
    private String topic2="8758d8c08ef06048e0530a0102136048-fabbfafa7f1943218820781d61a683a1";
    @Value("${spring.kafka.app.topic.foo3}")
    private String topic3="9c1baca06c3f47e08d80b6c163cb49d7-fabbfafa7f1943218820781d61a683a1";
    @Value("${spring.kafka.app.topic.foo4}")
    private String topic4="c100d3a342ba4b6997f63458e27d3531-fabbfafa7f1943218820781d61a683a1";
    @Value("${spring.kafka.app.topic.foo5}")
    private String topic5="668ae9add7f249e490055240cae5e9ce-fabbfafa7f1943218820781d61a683a1";
    @Value("${spring.kafka.app.topic.foo6}")
    private String topic6="91f30ef49a6c4cea9452d13bef00f71b";
    @Value("${spring.kafka.app.topic.foo7}")
    private String topic7="d67e3b6fdd17424c806ede6df6800b51";
    @Value("${spring.kafka.app.topic.foo8}")
    private String topic8="c5dde726063e42e98f6a20b3bb61d582";
    /** groupId*/
    private String GROUP_ID = "chenhao2019ady";
    /** topic*/
    // @Value("${kafka.topic}")
    /** 消费者个数*/
    private int TOPIC_COUNTMAP = 1;//可以通过topic分区个数来配置,消费者个数要<=分区个数

    private ExecutorService executorService;
    @Autowired
    InsertDataServiceImpl insertDataService;
    @Autowired
    UploadDataServiceImpl uploadDataService;
    @Autowired
    KafkaSimpleConsumer kafkaSimpleConsumer;
    @Override
    public void run(String... args) throws Exception {
        getKafka();
        writeKafka();
        readKafka();

    }
    private void getKafka(){
        String[] dpsps=new String[]{
                "20190628101703118148",
                "20190628101703118164",
                "20190628101703118190",
                "20190628101703118192",
                "20190628101703118208",
                "20190628101703118254",
                "20190628101703118265",
                "20190628101703118286",
                "20190628101703118302",
                "20190628101703118305",
                "20190628101703118323",
                "20190628101703118338",
                "20190628101703118356",
                "20190628101703118372",
                "20190628101703118373",
                "20190628101703118415",
                "20190628101703118426",
                "20190628101703118442",
                "20190628101704118458",
                "20190628101704118469",
                "20190628101704118522",
                "20190628102234118556",
                "20190628102234118557",
                "20190628102234118558",
                "20190628102234118559",
                "20190628102234118560",
                "20190628102234118561"
        };
        String[] zylsh=new String[]{
                "02416901",
                "02457294",
                "02455629",
                "02462251",
                "02431290",
                "02394495",
                "02466304",
                "02481315",
                "02477649",
                "02486697",
                "02437553",
                "02462196",
                "02455454",
                "02460829",
                "02409745",
                "02453453",
                "02465723",
                "02465647",
                "02473272",
                "02402108",
                "02411212",
                "02538941",
                "02513417",
                "02519550",
                "02521220",
                "02523105",
                "02541176"
        };
        int i=0;
        for(String dpsp:dpsps){
            KafkaConfiguration.WriteLPZT(dpsp, "00",zylsh[i]);
            i++;
            System.out.println(dpsp+"----------------------------");
            KafkaConfiguration.getLPZT(dpsp);
        }
    }
    private void writeKafka(){
        new KafkaProducer("91f30ef49a6c4cea9452d13bef00f71b","{\n" +
                "\t\"head\": {\n" +
                "\t\t\"appId\": \"fabbfafa7f1943218820781d61a683a1\",\n" +
                "\t\t\"requestId\": \"e43db39072434a00ac06c2feaeaf1719\"\n" +
                "\t},\n" +
                "\t\"body\": {\n" +
                "\t\t\"datas\": [{\n" +
                "\t\t\t\"value\": {\n" +
                "\t\t\t\t\"sfzhao\": \"440583198510104819\",\n" +
                "\t\t\t\t\"cbnyue\": \"201902\",\n" +
                "\t\t\t\t\"ywlx00\": \"00\"\n" +
                "\t\t\t}\n" +
                "\t\t}]\n" +
                "\t}\n" +
                "}").start();


    }

    public static void WriteLPZT(String pkid,String lpzt,String zylsh0) {
        new KafkaProducer("d67e3b6fdd17424c806ede6df6800b51","{\n" +
                "\t\"head\": {\n" +
                "\t\t\"appId\": \"fabbfafa7f1943218820781d61a683a1\",\n" +
                "\t\t\"requestId\": \"e43db39072434a00ac06c2feaeaf1719\"\n" +
                "\t},\n" +
                "\t\"body\": {\n" +
                "\t\t\"datas\": [{\n" +
                "\t\t\t\"value\": {\n" +
                "\t\t\t\t\"dbspid\":\""+pkid+"\",\n" +
                "\t\t\t\t\"lpzt00\":\""+ lpzt+"\",\n" +
                "\t\t\t\t\"lpsbyy\": \"\",\n" +
                "\t\t\t\t\"lprq00\": \"20190712\",\n" +
                "\t\t\t\t\"zylsh0\":\""+ zylsh0+"\",\n" +
                "\t\t\t\t\"djlsh0\": \"\"\n" +
                "\t\t\t}\n" +
                "\t\t}]\n" +
                "\t}\n" +
                "}").start();

    }

    public static void getLPZT(String pkid) {
        new KafkaProducer("c5dde726063e42e98f6a20b3bb61d582","{\n" +
                "\t\"head\": {\n" +
                "\t\t\"appId\": \"fabbfafa7f1943218820781d61a683a1\",\n" +
                "\t\t\"requestId\": \"e43db39072434a00ac06c2feaeaf1719\"\n" +
                "\t},\n" +
                "\t\"body\": {\n" +
                "\t\t\"datas\": [{\n" +
                "\t\t\t\"value\": {\n" +
                "\t\t\t\t\"dbspid\":\""+pkid+"\"\n" +
                "\t\t\t}\n" +
                "\t\t}]\n" +
                "\t}\n" +
                "}").start();
    }

    private void readKafka() {
        //10.1.3.147
        Properties properties = new Properties();
        properties.put("zookeeper.connect",
                "10.1.3.145:2181");// 声明zk
        properties.put("group.id", GROUP_ID);// 必须要使用别的组名称,// 如果生产者和消费者都在同一组，则不能访问同一组内的topic数据
        properties.put("zookeeper.session.timeout.ms", "4000");
        properties.put("zookeeper.sync.time.ms", "200");
        properties.put("auto.commit.interval.ms", "1000");
        properties.put("auto.offset.reset", "smallest");
        properties.put("serializer.class", "kafka.serializer.StringEncoder");
        ConsumerConnector consumer =
                Consumer.createJavaConsumerConnector(new ConsumerConfig(properties));
        Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
        // 这里可以设置创建多个消费者
        topicCountMap.put(topic, TOPIC_COUNTMAP);
        topicCountMap.put(topic1, TOPIC_COUNTMAP);
        topicCountMap.put(topic2, TOPIC_COUNTMAP);
        topicCountMap.put(topic3, TOPIC_COUNTMAP);
        topicCountMap.put(topic4, TOPIC_COUNTMAP);
        topicCountMap.put(topic5, TOPIC_COUNTMAP);
/*        topicCountMap.put(topic6, TOPIC_COUNTMAP);*/
  /*    topicCountMap.put(topic7, TOPIC_COUNTMAP);*/
      /*    topicCountMap.put(topic8, TOPIC_COUNTMAP);*/
        StringDecoder keyDecoder = new StringDecoder(new VerifiableProperties());
        StringDecoder valueDecoder = new StringDecoder(new VerifiableProperties());
        Map<String, List<KafkaStream<String, String>>>  messageStreams = consumer.createMessageStreams(topicCountMap,
                keyDecoder, valueDecoder);
     /*   Map<String, List<KafkaStream<String, String>>> messageStreams =
                consumer.createMessageStreams(topicCountMap);*/
        executorService = Executors.newFixedThreadPool(8);
        // 获取每次接收到的这个数据
        messageStreams.values().stream().forEach(value -> {
                    List<KafkaStream<String, String>> streams = value;
                    /**
                     * 可以为每隔topic创建一个线程池，因为每个topic我设置的partition=6
                     * （kafka consumer通过增加线程数来增加消费能力，但是需要足够的分区，如目前我设置的partition=6，那么并发可以启动6个线程同时消费）
                     * ExecutorService pool = createThreadPool();
                     */
                    for (final KafkaStream stream : streams) {
                        executorService.submit(new Runnable() {
                            int i=0;
                            @Override
                            public void run() {
                                ConsumerIterator<String, String> iterator = stream.iterator();
                                while (iterator.hasNext()) {
                                    final MessageAndMetadata<String, String> messageAndMetadata = iterator.next();
                                    final String content= messageAndMetadata.message();
                                    System.out.println(messageAndMetadata.message()+".............");
                                    kafkaSimpleConsumer.insertMessage(content,messageAndMetadata.topic());
                                }
                            }
                        });
                    }
                }
        );
    }

}
