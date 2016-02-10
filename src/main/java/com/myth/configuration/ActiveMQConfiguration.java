package com.myth.configuration;

import javax.jms.ConnectionFactory;
import javax.jms.MessageListener;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.SingleConnectionFactory;
import org.springframework.jms.listener.DefaultMessageListenerContainer;


@Configuration
public class ActiveMQConfiguration {
	
    @Bean(name = "activeMQQueue")
    public ActiveMQQueue activeMQQueue(){
    	return new ActiveMQQueue("queue");
    }
    
    @Bean(name = "connectionFactory")
    public SingleConnectionFactory singleConnectionFactory(ActiveMQConnectionFactory targetConnectionFactory){
    	SingleConnectionFactory singleConnectionFactory = new SingleConnectionFactory();
    	singleConnectionFactory.setTargetConnectionFactory(targetConnectionFactory);
    	return singleConnectionFactory;
    }
    
    @Bean(name = "targetConnectionFactory")
    public ActiveMQConnectionFactory activeMQConnectionFactory(){
    	ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
    	activeMQConnectionFactory.setBrokerURL("tcp://localhost:61616");
    	return activeMQConnectionFactory;
    }

	/**
	 * 注：
	 * ActiveMQQueue implements Queue class
	 * and Queue extends Destination
	 * 
	 * @param connectionFactory
	 * @param activeMQQueue
	 * @param activeMQMessageListener
	 * @return
	 */
	@Bean
	public DefaultMessageListenerContainer Container(ConnectionFactory connectionFactory,
			ActiveMQQueue activeMQQueue,MessageListener messageListener) {
		DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setDestination(activeMQQueue);
		container.setSessionAcknowledgeMode(2);
		container.setMessageListener(messageListener);
		return container; 
	}

}
