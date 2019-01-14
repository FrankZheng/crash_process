package com.frank.zheng.crash_process;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrashProcessApplication {

	private static final Logger logger = LoggerFactory.getLogger(CrashProcessApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CrashProcessApplication.class, args);
		logger.info("Hello World");
	}

}

