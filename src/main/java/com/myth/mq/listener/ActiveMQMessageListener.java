package com.myth.mq.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("activeMQMessageListener")
public class ActiveMQMessageListener implements MessageListener {
	public static final Logger logger = LoggerFactory.getLogger(ActiveMQMessageListener.class);
 
	@Override
	public void onMessage(Message message) {
		try {
			String text = ((TextMessage) message).getText();
			logger.info("message received: {}", text);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
