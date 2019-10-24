package com.middle.controller.Kafka;

import com.alibaba.fastjson.JSONObject;
import com.middle.utils.Array2List;
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import kafka.serializer.StringEncoder;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class KafkaProducer extends Thread {
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
    private String cTopic;
    private String msg;

    public KafkaProducer(String topic,String msg) {
        super();
        this.cTopic = topic;
        this.msg = msg;
    }

    @Override
    public void run() {

        Producer producer = createProducer();
            try {
                producer.send(new KeyedMessage<Integer, String>(cTopic, msg));
            } catch (Exception e) {
                e.printStackTrace();
            }
    }


    private Producer createProducer() {
        Properties properties = new Properties();
        //声明zk10.1.3.147
        properties.put("zookeeper.connect", "10.1.3.145:2181");
        properties.put("serializer.class", StringEncoder.class.getName());
        properties.put("metadata.broker.list", "10.1.3.145:9092");
        properties.put("batch.size", 4096);
        return new Producer<Integer, String>(new ProducerConfig(properties));
    }


    public static void main(String[] args) {


     /*   new KafkaProducer("780409b81da84934b8f696c15e1f1c83","{\n" +
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
                "\t\t\"jx0000\": \"\"\n" +
                "\t\t}\n" +
                "\t}]}\n" +
                "}").start();
      new KafkaProducer("a08b3d63ef774285a9553661e61eadcd","{\n" +
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
                "}").start();




        new KafkaProducer("668ae9add7f249e490055240cae5e9ce-fabbfafa7f1943218820781d61a683a1","{\n" +
                "\t\"head\": {\n" +
                "\t\t\"appId\": \"\",\n" +
                "\t\t\"requestId\": \"768f27bda32140cbabe66abec3933dfb\"\n" +
                "\t},\n" +
                "\t\"body\": {\n" +
                "\t\t\"datas\": [{\n" +
                "\t\t\t\"value\": {\n" +
                "\t\t\t\t\"dbspid\": \"13423423\",\n" +
                "\t\t\t\t\"lpzt00\": \"123423423\"\n" +
                "\t\t\t}\n"
        ).start();

        new KafkaProducer("8758d8c08ef06048e0530a0102136048-fabbfafa7f1943218820781d61a683a1","{\n" +
                "\t\"head\": {\n" +
                "\t\t\"appId\": \"\",\n" +
                "\t\t\"requestId\": \"ed520b6cdcca403db2b7e734fac789b6\"\n" +
                "\t},\n" +
                "\t\"body\": {\n" +
                "\t\t\"datas\": [{\n" +
                "\t\t\t\"value\": {\n" +
                "\t\t\t\t\"qhdm00\": \"10001\",\n" +
                "\t\t\t\t\"ywlx00\": \"职工医保\",\n" +
                "\t\t\t\t\"cbzt00\": \"未参保\",\n" +
                "\t\t\t\t\"id0000\": \"1123123211312\",\n" +
                "\t\t\t\t\"xbie00\": \"男\",\n" +
                "\t\t\t\t\"zjlx00\": \"身份证\",\n" +
                "\t\t\t\t\"zjhm00\": \"42343242342\",\n" +
                "\t\t\t\t\"csrq00\": \"2018-3-12\",\n" +
                "\t\t\t\t\"rysx00\": \"职工\",\n" +
                "\t\t\t\t\"qsrq00\": \"2018-3-12\",\n" +
                "\t\t\t\t\"jzrq00\": \"2018-3-19\",\n" +
                "\t\t\t\t\"txdzhi\": \"铁岭赤水沟子\",\n" +
                "\t\t\t\t\"dhua00\": \"112312312\",\n" +
                "\t\t\t\t\"xming0\": \"陈壮壮\"\n" +
                "\t\t\t}\n" +
                "\t\t}]\n" +
                "\t}\n" +
                "}").start();*/
       /* new KafkaProducer("a08b3d63ef774285a9553661e61eadcd", "{\n" +
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
                "}").start();
        new KafkaProducer("9c1baca06c3f47e08d80b6c163cb49d7-fabbfafa7f1943218820781d61a683a1", "{\n" +
                "\t\"head\": {\n" +
                "\t\t\"appId\": null,\n" +
                "\t\t\"requestId\": null\n" +
                "\t},\n" +
                "\t\"body\": {\n" +
                "\t\t\"datas\": [{\n" +
                "\t\t\t\"value\": {\n" +
                "\t\t\t\t\"pkid00\": \"20190628102234118556\",\n" +
                "\t\t\t\t\"sbcwpc\": null,\n" +
                "\t\t\t\t\"jzlx00\": \"本人\",\n" +
                "\t\t\t\t\"fwwdbh\": \"1101\",\n" +
                "\t\t\t\t\"fzxbh0\": \"01\",\n" +
                "\t\t\t\t\"grxx\": {\n" +
                "\t\t\t\t\t\"ywlx00\": \"职工\",\n" +
                "\t\t\t\t\t\"xming0\": \"方满辉\",\n" +
                "\t\t\t\t\t\"xbie00\": \"1\",\n" +
                "\t\t\t\t\t\"cbzt00\": \"1\",\n" +
                "\t\t\t\t\t\"id0000\": \"440503196510301256\",\n" +
                "\t\t\t\t\t\"xsetx0\": null,\n" +
                "\t\t\t\t\t\"zj\": {\n" +
                "\t\t\t\t\t\t\"zjlx00\": \"\",\n" +
                "\t\t\t\t\t\t\"zjhm00\": \"440503196510301256\"\n" +
                "\t\t\t\t\t}\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\"zyxx\": {\n" +
                "\t\t\t\t\t\"zylsh0\": \"ZY02538941\",\n" +
                "\t\t\t\t\t\"zyrq00\": \"20190325\",\n" +
                "\t\t\t\t\t\"jbyblx\": \"\",\n" +
                "\t\t\t\t\t\"cwhao0\": \"\",\n" +
                "\t\t\t\t\t\"jzks00\": \"\",\n" +
                "\t\t\t\t\t\"zd\": {\n" +
                "\t\t\t\t\t\t\"cszd00\": \"\",\n" +
                "\t\t\t\t\t\t\"bfz000\": \"\",\n" +
                "\t\t\t\t\t\t\"zzdjb0\": \"\",\n" +
                "\t\t\t\t\t\t\"qtzdjb\": \"\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"sfcetk\": \"N\",\n" +
                "\t\t\t\t\t\"zylsh0Old\": \"\"\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\"cyxx\": {\n" +
                "\t\t\t\t\t\"cyrq00\": \"20190325\",\n" +
                "\t\t\t\t\t\"cyzd00\": \"非霍奇金淋巴瘤\"\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\"zysfmx\": [{\n" +
                "\t\t\t\t\t\"pkid00\": \"8CD2AECA1DE3009AE0530A01022A009A\",\n" +
                "\t\t\t\t\t\"xmbh00\": \"01500010431000\",\n" +
                "\t\t\t\t\t\"xmmc00\": \"利妥昔单抗（100mg/10ml/瓶）\",\n" +
                "\t\t\t\t\t\"yplb\": \"2\",\n" +
                "\t\t\t\t\t\"fpxmbh\": \"1\",\n" +
                "\t\t\t\t\t\"zfbl00\": \".1\",\n" +
                "\t\t\t\t\t\"yysdmlbh\": \"2201700\",\n" +
                "\t\t\t\t\t\"yysdmlmc\": \"利妥昔单抗(美罗华)注射液\",\n" +
                "\t\t\t\t\t\"xmje00\": \"13766.64\",\n" +
                "\t\t\t\t\t\"xmsl00\": \"6\",\n" +
                "\t\t\t\t\t\"xmdj00\": \"2294.44\",\n" +
                "\t\t\t\t\t\"orderExecutedDate\": \"2019-03-25\"\n" +
                "\t\t\t\t}, {\n" +
                "\t\t\t\t\t\"pkid00\": \"8CD2AECA1DE4009AE0530A01022A009A\",\n" +
                "\t\t\t\t\t\"xmbh00\": \"06130600001000\",\n" +
                "\t\t\t\t\t\"xmmc00\": \"家庭病床建床费\",\n" +
                "\t\t\t\t\t\"yplb\": \"9\",\n" +
                "\t\t\t\t\t\"fpxmbh\": \"2\",\n" +
                "\t\t\t\t\t\"zfbl00\": \".999999\",\n" +
                "\t\t\t\t\t\"yysdmlbh\": \"130600001\",\n" +
                "\t\t\t\t\t\"yysdmlmc\": \"家庭病床建床费\",\n" +
                "\t\t\t\t\t\"xmje00\": \"40\",\n" +
                "\t\t\t\t\t\"xmsl00\": \"2\",\n" +
                "\t\t\t\t\t\"xmdj00\": \"20\",\n" +
                "\t\t\t\t\t\"orderExecutedDate\": \"2019-03-25\"\n" +
                "\t\t\t\t}]\n" +
                "\t\t\t}\n" +
                "\t\t}]\n" +
                "\t}\n" +
                "}").start();*/
/*        new KafkaProducer("9c1baca06c3f47e08d80b6c163cb49d7-fabbfafa7f1943218820781d61a683a1","{\"head\":{\"appId\":null,\"requestId\":null},\"body\":{\"datas\":[{\"value\":{\"pkid00\":\"20190525143008112853\",\"sbcwpc\":null,\"jzlx00\":\"本人\",\"fwwdbh\":null,\"grxx\":{\"ywlx00\":null,\"xming0\":null,\"xbie00\":null,\"cbzt00\":null,\"id0000\":null,\"xsetx0\":null,\"zj\":null},\"zyxx\":{\"zylsh0\":\"ZY02455629\",\"zyrq00\":\"20190117\",\"jbyblx\":\"\",\"cwhao0\":\"\",\"jzks00\":\"\",\"zd\":{\"cszd00\":\"\",\"bfz000\":\"\",\"zzdjb0\":\"\",\"qtzdjb\":\"\"},\"sfcetk\":\"N\",\"zylsh0Old\":\"\"},\"cyxx\":{\"cyrq00\":\"20190126\",\"cyzd00\":\"冠状动脉粥样硬化性心脏病\"},\"zysfmx\":[]}}]}}").start();*/
  /*   new KafkaProducer("c100d3a342ba4b6997f63458e27d3531-fabbfafa7f1943218820781d61a683a1","{\n" +
                "\t\"head\": {\n" +
                "\t\t\"appId\": \"\",\n" +
                "\t\t\"requestId\": \"d2bc05f75fdf442380c51f3e3a9ccd11\"\n" +
                "\t},\n" +
                "\t\"body\": {\n" +
                "\t\t\"datas\": [{\n" +
                "\t\t\t\"value\": {\n" +
                "\t\t\t\t\"pkid00\": \"111\",\n" +
                "\t\t\t\t\"sbcwpc\": \"11\",\n" +
                "\t\t\t\t\"jzlx00\": \"11\",\n" +
                "\t\t\t\t\"grxx\": {\n" +
                "\t\t\t\t\t\"ywlx00\": \"11\",\n" +
                "\t\t\t\t\t\"xming0\": \"11\",\n" +
                "\t\t\t\t\t\"xbie00\": \"111\",\n" +
                "\t\t\t\t\t\"cbzt00\": \"11\",\n" +
                "\t\t\t\t\t\"id0000\": \"11\",\n" +
                "\t\t\t\t\t\"xsetx0\": \"11\",\n" +
                "\t\t\t\t\t\"zj\": {\n" +
                "\t\t\t\t\t\t\"zjlx00\": \"11\",\n" +
                "\t\t\t\t\t\t\"zjhm00\": \"11\"\n" +
                "\t\t\t\t\t}\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\"zyxx\": {\n" +
                "\t\t\t\t\t\"zylsh0\": \"11\",\n" +
                "\t\t\t\t\t\"zyrq00\": \"11\",\n" +
                "\t\t\t\t\t\"jbyblx\": \"11\",\n" +
                "\t\t\t\t\t\"cwhao0\": \"11\",\n" +
                "\t\t\t\t\t\"jzks00 \": \"11 \",\n" +
                "\t\t\t\t\t\"zd \": {\n" +
                "\t\t\t\t\t\t\"cszd00 \": \"11 \",\n" +
                "\t\t\t\t\t\t\"bfz000 \": \"11 \",\n" +
                "\t\t\t\t\t\t\"zzdjb0 \": \"11 \",\n" +
                "\t\t\t\t\t\t\"qtzdjb \": \"11 \"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"sfcetk \": \"11\",\n" +
                "\t\t\t\t\t\"zylsh0Old\": \"11\"\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\"cyxx\": {\n" +
                "\t\t\t\t\t\"cyrq00\": \"11\",\n" +
                "\t\t\t\t\t\"cyzd00\": \"11\"\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\"zysfmx\": [{\n" +
                "\t\t\t\t\t\"pkid00\": \"11\",\n" +
                "\t\t\t\t\t\"xmbh00\": \"11\",\n" +
                "\t\t\t\t\t\"xmmc00\": \"11\",\n" +
                "\t\t\t\t\t\"yplb00\": \"11\",\n" +
                "\t\t\t\t\t\"fpxmbh\": \"11\",\n" +
                "\t\t\t\t\t\"zfbl00\": \"11\",\n" +
                "\t\t\t\t\t\"yysdmlbh\": \"11\",\n" +
                "\t\t\t\t\t\"yysdmlmc \": \"11\"\n" +
                "\t\t\t\t}]\n" +
                "\t\t\t}\n" +
                "\t\t}]\n" +
                "\t}\n" +
                "}").start();
     /*   new KafkaProducer("9c1baca06c3f47e08d80b6c163cb49d7-fabbfafa7f1943218820781d61a683a1","{\"head\":{\"appId\":null,\"requestId\":null},\"body\":{\"datas\":[{\"value\":{\"pkid00\":\"20190525143008112853\",\"sbcwpc\":null,\"jzlx00\":\"本人\",\"fwwdbh\":null,\"grxx\":{\"ywlx00\":null,\"xming0\":null,\"xbie00\":null,\"cbzt00\":null,\"id0000\":null,\"xsetx0\":null,\"zj\":null},\"zyxx\":{\"zylsh0\":\"ZY02455629\",\"zyrq00\":\"20190117\",\"jbyblx\":\"\",\"cwhao0\":\"\",\"jzks00\":\"\",\"zd\":{\"cszd00\":\"\",\"bfz000\":\"\",\"zzdjb0\":\"\",\"qtzdjb\":\"\"},\"sfcetk\":\"N\",\"zylsh0Old\":\"\"},\"cyxx\":{\"cyrq00\":\"20190126\",\"cyzd00\":\"冠状动脉粥样硬化性心脏病\"},\"zysfmx\":[]}}]}}").start();
        new KafkaProducer("c100d3a342ba4b6997f63458e27d3531-fabbfafa7f1943218820781d61a683a1","{\n" +
                "\t\"head\": {\n" +
                "\t\t\"appId\": \"\",\n" +
                "\t\t\"requestId\": \"2ad9d6d965f44de09af00cdbe9bb0750\"\n" +
                "\t},\n" +
                "\t\"body\": {\n" +
                "\t\t\"datas\": [{\n" +
                "\t\t\t\"value\": {\n" +
                "\t\t\t\t\"pkid00\": \"123123\",\n" +
                "\t\t\t\t\"dbspid\": \"12321312\",\n" +
                "\t\t\t\t\"ybhao0\": \"312312\",\n" +
                "\t\t\t\t\"xming0\": \"阿达\",\n" +
                "\t\t\t\t\"xbie00\": \"男\",\n" +
                "\t\t\t\t\"zj\": {\n" +
                "\t\t\t\t\t\"zjlx00\": \"23423\",\n" +
                "\t\t\t\t\t\"zjhm00\": \"234234\"\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\"yyjsh\": \"23423\",\n" +
                "\t\t\t\t\"rylx00\": \"23423\",\n" +
                "\t\t\t\t\"lyzt00\": \"234234\",\n" +
                "\t\t\t\t\"swsj00\": \"23423\",\n" +
                "\t\t\t\t\"lyzd00\": \"23423\",\n" +
                "\t\t\t\t\"bzf000\": \"23423\",\n" +
                "\t\t\t\t\" ssybnd\": \"23423\",\n" +
                "\t\t\t\t\"fy \": {\n" +
                "\t\t\t\t\t\"ylzfy0\": null,\n" +
                "\t\t\t\t\t\"jlfy00\": \"23423\",\n" +
                "\t\t\t\t\t\"ylfy00\": \"23423\",\n" +
                "\t\t\t\t\t\"ylzf00\": \"2342\",\n" +
                "\t\t\t\t\t\"blyb00\": \"234234\",\n" +
                "\t\t\t\t\t\"blzf00\": \"23423\",\n" +
                "\t\t\t\t\t\"zyfy00\": \"234234\",\n" +
                "\t\t\t\t\t\"xyfy00\": \"234234\",\n" +
                "\t\t\t\t\t\"nrbybtc\": \"234234\",\n" +
                "\t\t\t\t\t\"dbbcfy\": \"234234\",\n" +
                "\t\t\t\t\t\"nddbbcfy\": \"23423432\",\n" +
                "\t\t\t\t\t\"sfcetk\": \"4234234\",\n" +
                "\t\t\t\t\t\"zylsh0_old\": \"23423\",\n" +
                "\t\t\t\t\t\"sjdbbcfy\": \"234324\",\n" +
                "\t\t\t\t\t\"jbylqfx\": \"23423423\",\n" +
                "\t\t\t\t\t\"thirdPartyCompensation\": \"23423423\"\n" +
                "\t\t\t\t}\n" +
                "\t\t\t}\n" +
                "\t\t}]\n" +
                "\t}\n" +
                "}").start();*/
        new KafkaProducer("c100d3a342ba4b6997f63458e27d3531-fabbfafa7f1943218820781d61a683a1","{\n" +
                "\t\"head\": {\n" +
                "\t\t\"appId\": \"\",\n" +
                "\t\t\"requestId\": \"2ad9d6d965f44de09af00cdbe9bb0750\"\n" +
                "\t},\n" +
                "\t\"body\": {\n" +
                "\t\t\"datas\": [{\n" +
                "\t\t\t\"value\": {\n" +
                "\t\t\t\t\"pkid00\": \"123123123\",\n" +
                "\t\t\t\t\"dbspid\": \"12321312\",\n" +
                "\t\t\t\t\"ybhao0\": \"312312\",\n" +
                "\t\t\t\t\"xming0\": \"阿达123\",\n" +
                "\t\t\t\t\"xbie00\": \"男\",\n" +
                "\t\t\t\t\"zj\": {\n" +
                "\t\t\t\t\t\"zjlx00\": \"23423\",\n" +
                "\t\t\t\t\t\"zjhm00\": \"234234\"\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\"yyjsh\": \"23423\",\n" +
                "\t\t\t\t\"rylx00\": \"23423\",\n" +
                "\t\t\t\t\"lyzt00\": \"234234\",\n" +
                "\t\t\t\t\"swsj00\": \"23423\",\n" +
                "\t\t\t\t\"lyzd00\": \"23423\",\n" +
                "\t\t\t\t\"bzf000\": \"23423\",\n" +
                "\t\t\t\t\" ssybnd\": \"23423\",\n" +
                "\t\t\t\t\"fy \": {\n" +
                "\t\t\t\t\t\"ylzfy0\": null,\n" +
                "\t\t\t\t\t\"jlfy00\": \"23423\",\n" +
                "\t\t\t\t\t\"ylfy00\": \"23423\",\n" +
                "\t\t\t\t\t\"ylzf00\": \"2342\",\n" +
                "\t\t\t\t\t\"blyb00\": \"234234\",\n" +
                "\t\t\t\t\t\"blzf00\": \"23423\",\n" +
                "\t\t\t\t\t\"zyfy00\": \"234234\",\n" +
                "\t\t\t\t\t\"xyfy00\": \"234234\",\n" +
                "\t\t\t\t\t\"nrbybtc\": \"234234\",\n" +
                "\t\t\t\t\t\"dbbcfy\": \"234234\",\n" +
                "\t\t\t\t\t\"nddbbcfy\": \"23423432\",\n" +
                "\t\t\t\t\t\"sfcetk\": \"4234234\",\n" +
                "\t\t\t\t\t\"zylsh0_old\": \"23423\",\n" +
                "\t\t\t\t\t\"sjdbbcfy\": \"234324\",\n" +
                "\t\t\t\t\t\"jbylqfx\": \"23423423\",\n" +
                "\t\t\t\t\t\"thirdPartyCompensation\": \"23423423\"\n" +
                "\t\t\t\t\t\"cwzfpc\": \"234324\",\n" +
                "\t\t\t\t\t\"jsnd00\": \"23423423\",\n" +
                "\t\t\t\t\t\"sfxsesm\": \"23423423\"\n" +
                "\t\t\t\t}\n" +
                "\t\t\t}\n" +
                "\t\t}]\n" +
                "\t}\n" +
                "}").start();
    }

}