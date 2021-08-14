package com.ms.practice.practiceServiceDiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PracticeServiceDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeServiceDiscoveryApplication.class, args);
	}

}
