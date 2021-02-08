package com.nhn.rookie8.sample.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class SampleAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleAccountApplication.class, args);
	}

	@Configuration
	public class ContainerConfig {

	}

}
