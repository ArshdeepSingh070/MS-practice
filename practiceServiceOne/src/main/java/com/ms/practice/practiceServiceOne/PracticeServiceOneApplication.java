package com.ms.practice.practiceServiceOne;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class PracticeServiceOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeServiceOneApplication.class, args);
	}
	
	@Bean(name = "restTemplate")
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
