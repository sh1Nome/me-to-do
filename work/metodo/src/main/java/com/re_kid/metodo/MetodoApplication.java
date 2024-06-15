package com.re_kid.metodo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.re_kid.metodo.property.MeToDoLogUrl;

@SpringBootApplication
public class MetodoApplication {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private final MeToDoLogUrl meToDoLogUrl;

	public MetodoApplication(MeToDoLogUrl meToDoLogUrl) {
		this.meToDoLogUrl = meToDoLogUrl;
	}

	public void debugLog() {
		logger.debug(meToDoLogUrl.getApp());
		logger.debug(meToDoLogUrl.getAdminer());
	}

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(MetodoApplication.class, args);
		MetodoApplication metodoApplication = context.getBean(MetodoApplication.class);
		metodoApplication.debugLog();
	}

}
