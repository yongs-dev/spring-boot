package com.spring.mark;

import com.spring.mark.aopexample.business.BusinessService1;
import com.spring.mark.aopexample.business.BusinessService2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MarkApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(getClass());

	private final BusinessService1 businessService1;
	private final BusinessService2 businessService2;

	public MarkApplication(BusinessService1 businessService1, BusinessService2 businessService2) {
		this.businessService1 = businessService1;
		this.businessService2 = businessService2;
	}

	public static void main(String[] args) {
		SpringApplication.run(MarkApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("result = {}", businessService1.calculateMax());
		logger.info("result = {}", businessService2.calculateMin());
	}
}
