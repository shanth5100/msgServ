package com.msgSev.actvMQ.producer;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class Producer extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
//		from("activemq:myMq")
//		.to("log:myLog");
		from("timer:active-mq-timer?period=60000")
		.transform().constant("Hello Message from Apache Camel ")
        .log("${body}")
        //send this message to ActiveMQ queue
        .to("activemq:my-activemq-queue");
	}

}
