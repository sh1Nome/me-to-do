package com.re_kid.metodo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MetodoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(MetodoApplication.class, args);
		MetodoApplicationService metodoApplicationService = context.getBean(MetodoApplicationService.class);
		metodoApplicationService.initMetodoUser();
	}

}
