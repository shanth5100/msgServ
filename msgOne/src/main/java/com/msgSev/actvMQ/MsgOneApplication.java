package com.msgSev.actvMQ;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MsgOneApplication {

	public static void main(String[] args) {
		Logger log = LoggerFactory.getLogger(MsgOneApplication.class);
		log.info("args info: " + args);
		log.debug("args debug: " + args);
		log.error("args error: " + args);
		SpringApplication.run(MsgOneApplication.class, args);
	}

}
