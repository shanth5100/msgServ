package com.msgSev.actvMQ.consumer;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Consumer1 extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		Logger log = LoggerFactory.getLogger(Consumer1.class);
		log.info("args before: " + "args");
		// TODO Auto-generated method stub
//		from("activemq:myMq")
//		.to("log:myLog");
		log.info("args After: " + "args");
	}

}
