package com.ms.practice.practiceServiceTwo.controllers;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
@RequestMapping(value = "/two")
public class ServiceTwoController {
	
	@Autowired
	private EurekaClient eurekaClient;
	
	@Resource(name = "restTemplate")
	private RestTemplate restTemplate;
	
	@GetMapping
	public String showTwo() {
		return "two";
	}

	@GetMapping( value = "/responseToOne")
	public String reponseToServiceOne() {
		return "Hi Service One";
	}
	
	@GetMapping(value = "/callOne")
	public String callTwo() {
		
		String response;
		String url = "/one/responseToTwo";
		InstanceInfo instance = eurekaClient.getNextServerFromEureka("serviceOne", false);
		response = restTemplate.getForObject(instance.getHomePageUrl() + url , String.class);
		return response;
		
	}
}
