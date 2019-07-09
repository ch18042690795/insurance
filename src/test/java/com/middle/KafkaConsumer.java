package com.middle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.serializer.StringDecoder;
import kafka.utils.VerifiableProperties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Value;

public class KafkaConsumer {
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
	private final ConsumerConnector consumer;

	private KafkaConsumer() {
		Properties props = new Properties();
		//zookeeper 配置
		props.put("zookeeper.connect", "192.168.17.1:2181");

		//group 代表一个消费组
		props.put("group.id", "jd-group");

		//zk连接超时
		props.put("zookeeper.session.timeout.ms", "4000");
		props.put("zookeeper.sync.time.ms", "200");
		props.put("auto.commit.interval.ms", "1000");
		props.put("auto.offset.reset", "smallest");
		//序列化类
		props.put("serializer.class", "kafka.serializer.StringEncoder");

		ConsumerConfig config = new ConsumerConfig(props);

		consumer = kafka.consumer.Consumer.createJavaConsumerConnector(config);
	}

	void consume(String topic) {
		Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
		topicCountMap.put(topic, new Integer(1));

		StringDecoder keyDecoder = new StringDecoder(new VerifiableProperties());
		StringDecoder valueDecoder = new StringDecoder(new VerifiableProperties());

		Map<String, List<KafkaStream<String, String>>> consumerMap =
				consumer.createMessageStreams(topicCountMap,keyDecoder,valueDecoder);
		KafkaStream<String, String> stream = consumerMap.get(topic).get(0);
		ConsumerIterator<String, String> it = stream.iterator();
		while (it.hasNext())
			System.out.println(it.next().message());
	}

	public static void main(String[] args) {
		String topic1 = "a08b3d63ef774285a9553661e61eadcd";
		String topic = "780409b81da84934b8f696c15e1f1c83";
		String[] lists=new String[]{topic,topic1};
		for (String list:lists){
			new KafkaConsumer().consume(list);
		}


	}
}