package com.myth.kafka;

import java.io.UnsupportedEncodingException;
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

public class KafkaConsumer {
	 
    private final ConsumerConnector consumer;
 
    private KafkaConsumer() {
        Properties props = new Properties();
        //zookeeper 配置
        props.put("zookeeper.connect", "127.0.0.1");
 
        //group 代表一个消费组
        props.put("group.id", "yundianbo-group");
 
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
 
    void consume() {
        Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
        topicCountMap.put(KafkaProducer.TOPIC, new Integer(1));
 
        StringDecoder keyDecoder = new StringDecoder(new VerifiableProperties());
        StringDecoder valueDecoder = new StringDecoder(new VerifiableProperties());
 
        Map<String, List<KafkaStream<String, String>>> consumerMap =
                consumer.createMessageStreams(topicCountMap,keyDecoder,valueDecoder);
        KafkaStream<String, String> stream = consumerMap.get(KafkaProducer.TOPIC).get(0);
        ConsumerIterator<String, String> it = stream.iterator();
        while (it.hasNext()){
        	System.out.println("----------------------");
            System.out.println(it.next().message());
        }
        
        
//      Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumer.createMessageStreams(topicCountMap);
//      List<KafkaStream<byte[], byte[]>> streams = consumerMap.get(KafkaProducer.TOPIC);
//		for (KafkaStream stream : streams) {
//			ConsumerIterator<byte[], byte[]> it = stream.iterator();
//			while (it.hasNext()) { // 阻塞获取信息
//				String log;
//				try {
//					log = new String(it.next().message(), "utf-8");
//					System.out.println("---------------------");
//					System.out.println(log);
//				} catch (UnsupportedEncodingException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//			}
//		}
    }
 
    public static void main(String[] args) {
        new KafkaConsumer().consume();
    }
}