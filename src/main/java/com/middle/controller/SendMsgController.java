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
        kafKaCustomrProducer.sendMessage(topic3, "{\n" +
                "\t\"head\": {\n" +
                "\t\t\"appId\": \"\",\n" +
                "\t\t\"requestId\": \"c2bc05f75fdf442380c51f3e3a9ccd11\"\n" +
                "\t},\n" +
                "\t\"body\": {\n" +
                "\t\t\"datas\": [{\n" +
                "\t\t\t\"value\": {\n" +
                "\t\t\t\t\"pkid00\": \"1\",\n" +
                "\t\t\t\t\"sbcwpc\": \"1\",\n" +
                "\t\t\t\t\"jzlx00\": \"1\",\n" +
                "\t\t\t\t\"grxx\": {\n" +
                "\t\t\t\t\t\"ywlx00\": \"2\",\n" +
                "\t\t\t\t\t\"xming0\": \"2\",\n" +
                "\t\t\t\t\t\"xbie00\": \"2\",\n" +
                "\t\t\t\t\t\"cbzt00\": \"2\",\n" +
                "\t\t\t\t\t\"id0000\": \"2\",\n" +
                "\t\t\t\t\t\"xsetx0\": \"2\",\n" +
                "\t\t\t\t\t\"zj\": {\n" +
                "\t\t\t\t\t\t\"zjlx00\": \"3\",\n" +
                "\t\t\t\t\t\t\"zjhm00\": \"3\"\n" +
                "\t\t\t\t\t}\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\"zyxx\": {\n" +
                "\t\t\t\t\t\"zylsh0\": \"2\",\n" +
                "\t\t\t\t\t\"zyrq00\": \"2017-3-12 12:12:10\",\n" +
                "\t\t\t\t\t\"jbyblx\": \"2\",\n" +
                "\t\t\t\t\t\"cwhao0\": \"2\",\n" +
                "\t\t\t\t\t\"jzks00\": \"2\",\n" +
                "\t\t\t\t\t\"zd\": {\n" +
                "\t\t\t\t\t\t\"cszd00\": \"3\",\n" +
                "\t\t\t\t\t\t\"bfz000\": \"3\",\n" +
                "\t\t\t\t\t\t\"zzdjb0\": \"3\",\n" +
                "\t\t\t\t\t\t\"qtzdjb\": \"3\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"sfcetk\": \"2\",\n" +
                "\t\t\t\t\t\"zylsh0Old\": \"2\"\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\"cyxx\": {\n" +
                "\t\t\t\t\t\"cyrq00\": \"\",\n" +
                "\t\t\t\t\t\"cyzd00\": \"2\"\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\"zysfmx\": [{\n" +
                "\t\t\t\t\t\"pkid00\": \"2\",\n" +
                "\t\t\t\t\t\"xmbh00\": \"2\",\n" +
                "\t\t\t\t\t\"xmmc00\": \"2\",\n" +
                "\t\t\t\t\t\"yplb00\": \"2\",\n" +
                "\t\t\t\t\t\"fpxmbh\": \"2\",\n" +
                "\t\t\t\t\t\"zfbl00\": \"2\",\n" +
                "\t\t\t\t\t\"yysdmlbh\": \"2\",\n" +
                "\t\t\t\t\t\"yysdmlmc\": \"2\"\n" +
                "\t\t\t\t}]\n" +
                "\t\t\t}\n" +
                "\t\t}]\n" +
                "\t}\n" +
                "}");
        kafKaCustomrProducer.sendMessage(topic4, "{\n" +
                "\t\"head\": {\n" +
                "\t\t\"appId\": \"\",\n" +
                "\t\t\"requestId\": \"2ad9d6d965f44de09af00cdbe9bb0750\"\n" +
                "\t},\n" +
                "\t\"body\": {\n" +
                "\t\t\"datas\": [{\n" +
                "\t\t\t\"value\": {\n" +
                "\t\t\t\t\"pkid00\": \"\",\n" +
                "\t\t\t\t\"dbspid\": \"1\",\n" +
                "\t\t\t\t\"ybhao0\": \"1\",\n" +
                "\t\t\t\t\"xming0\": \"1\",\n" +
                "\t\t\t\t\"xbie00\": \"1\",\n" +
                "\t\t\t\t\"zj\": {\n" +
                "\t\t\t\t\t\"zjlx00\": \"2\",\n" +
                "\t\t\t\t\t\"zjhm00\": \"2\"\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\"yyjsh\": \"1\",\n" +
                "\t\t\t\t\"rylx00\": \"1\",\n" +
                "\t\t\t\t\"lyzt00\": \"1\",\n" +
                "\t\t\t\t\"swsj00\": \"1\",\n" +
                "\t\t\t\t\"lyzd00\": \"1\",\n" +
                "\t\t\t\t\"bzf000\": \"1\",\n" +
                "\t\t\t\t\"fy\": {\n" +
                "\t\t\t\t\t\"ylzfy0\": null,\n" +
                "\t\t\t\t\t\"jlfy00\": \"2\",\n" +
                "\t\t\t\t\t\"ylfy00\": \"2\",\n" +
                "\t\t\t\t\t\"ylzf00\": \"2\",\n" +
                "\t\t\t\t\t\"blyb00\": \"2\",\n" +
                "\t\t\t\t\t\"blzf00\": \"2\",\n" +
                "\t\t\t\t\t\"zyfy00\": \"2\",\n" +
                "\t\t\t\t\t\"xyfy00\": \"2\",\n" +
                "\t\t\t\t\t\"nrbybtc\": \"2\",\n" +
                "\t\t\t\t\t\"dbbcfy\": \"2\",\n" +
                "\t\t\t\t\t\"nddbbcfy\": \"2\",\n" +
                "\t\t\t\t\t\"sfcetk\": \"2\",\n" +
                "\t\t\t\t\t\"zylsh0_old\": \"2\",\n" +
                "\t\t\t\t\t\"sjdbbcfy\": \"2\",\n" +
                "\t\t\t\t\t\"jbylqfx\": \"2\"\n" +
                "\t\t\t\t}\n" +
                "\t\t\t}\n" +
                "\t\t}]\n" +
                "\t}\n" +
                "}");
        kafKaCustomrProducer.sendMessage(topic2, "{\n" +
                "\t\"head\": {\n" +
                "\t\t\"appId\": \"\",\n" +
                "\t\t\"requestId\": \"ed520b6cdcca403db2b7e734fac789b6\"\n" +
                "\t},\n" +
                "\t\"body\": {\n" +
                "\t\t\"datas\": [{\n" +
                "\t\t\t\"value\": {\n" +
                "\t\t\t\t\"qhdm00\": \"1\",\n" +
                "\t\t\t\t\"ywlx00\": \"1\",\n" +
                "\t\t\t\t\"cbzt00\": \"1\",\n" +
                "\t\t\t\t\"id0000\": \"1\",\n" +
                "\t\t\t\t\"xbie00\": \"1\",\n" +
                "\t\t\t\t\"zjlx00\": \"1\",\n" +
                "\t\t\t\t\"zjhm00\": \"1\",\n" +
                "\t\t\t\t\"csrq00\": \"\",\n" +
                "\t\t\t\t\"rysx00\": \"1\",\n" +
                "\t\t\t\t\"qsrq00\": \"\",\n" +
                "\t\t\t\t\"jzrq00\": \"\",\n" +
                "\t\t\t\t\"txdzhi\": \"1\",\n" +
                "\t\t\t\t\"dhua00\": \"1\"\n" +
                "\t\t\t}\n" +
                "\t\t}]\n" +
                "\t}\n" +
                "}");
        kafKaCustomrProducer.sendMessage(topic5, "{\n" +
                "\t\"head\": {\n" +
                "\t\t\"appId\": \"\",\n" +
                "\t\t\"requestId\": \"768f27bda32140cbabe66abec3933dfb\"\n" +
                "\t},\n" +
                "\t\"body\": {\n" +
                "\t\t\"datas\": [{\n" +
                "\t\t\t\"value\": {\n" +
                "\t\t\t\t\"dbspid\": \"1\",\n" +
                "\t\t\t\t\"lpzt00\": \"1\"\n" +
                "\t\t\t}\n" +
                "\t\t}]\n" +
                "\t}\n" +
                "}");
        kafKaCustomrProducer.sendMessage(topic6, "{\n" +
                "\t\"head\": {\n" +
                "\t\t\"appId\": \"xxxxxx\",\n" +
                "\t\t\"requestId\": \"xxxxxx\"\n" +
                "\t},\n" +
                "\t\"body\": {\n" +
                "\t\t\"datas\": [{\n" +
                "\t\t\t\"code\": \"00\",\n" +
                "\t\t\t\"message\": \"成功 \",\n" +
                "\t\t\t\"value\": {\n" +
                "\t\t\t\t\"sfzhao\": \"xxxxxx \",\n" +
                "\t\t\t\t\"cbnyue\": \"201902 \",\n" +
                "\t\t\t\t\"ywlx00\": \"01 \"\n" +
                "\t\t\t}\n" +
                "\t\t}]\n" +
                "\t}\n" +
                "}");
        kafKaCustomrProducer.sendMessage(topic7, "{\n" +
                "\t\"head\": {\n" +
                "\t\t\"appId\": \"\",\n" +
                "\t\t\"requestId\": \"7c431e11c4374b7ca4eb5497d5197132\"\n" +
                "\t},\n" +
                "\t\"body\": {\n" +
                "\t\t\"datas\": [{\n" +
                "\t\t\t\"value\": {\n" +
                "\t\t\t\t\"dbspid\": \"61f6841b6ef3434fa02319aacb9501d3\",\n" +
                "\t\t\t\t\"lpzt00\": \"1\",\n" +
                "\t\t\t\t\"lpsbyy\": \"1\",\n" +
                "\t\t\t\t\"lprq00\": \"\",\n" +
                "\t\t\t\t\"zylsh0\": \"1\",\n" +
                "\t\t\t\t\"djlsh0\": \"xxxxx\"\n" +
                "\t\t\t}\n" +
                "\t\t}]\n" +
                "\t}\n" +
                "}");

        kafKaCustomrProducer.sendMessage(topic8, "{\n" +
                "\t\"head\": {\n" +
                "\t\t\"appId\": \"\",\n" +
                "\t\t\"requestId\": \"e3505582f843469a86e21ab711dbad06\"\n" +
                "\t},\n" +
                "\t\"body\": {\n" +
                "\t\t\"datas\": [{\n" +
                "\t\t\t\"value\": {\n" +
                "\t\t\t\t\"dbspid\": \"7676897f682f4c6ca971d53eb2771322\"\n" +
                "\t\t\t}\n" +
                "\t\t}]\n" +
                "\t}\n" +
                "}");

    }
}

