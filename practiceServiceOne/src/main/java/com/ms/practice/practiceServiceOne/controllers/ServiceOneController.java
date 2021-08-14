package com.ms.practice.practiceServiceOne.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ms.practiceServiceOne.models.ServiceOne;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
@RequestMapping(value = "/one")
public class ServiceOneController {
	
	@Autowired
	private EurekaClient eurekaClient;
	
	@Resource(name = "restTemplate")
	private RestTemplate restTemplate;

	private Map<String , ServiceOne> services = new HashMap<>();
	
	@GetMapping
	public String showOne() {
		return "one";
	}
	
	@GetMapping(value = "/callTwo")
	public String callServiceTwo() {
		
		String response;
		String url = "/two/responseToOne";
		InstanceInfo instance = eurekaClient.getNextServerFromEureka("serviceTwo", false);
		response = restTemplate.getForObject(instance.getHomePageUrl()+ url, String.class);
		return response;
	}
	
	@GetMapping( value = "/responseToTwo")
	public String reponseToServiceTwo() {
		return "Hi Service Two";
	}
	
	@PostMapping("/add")
	public ServiceOne addServiceOne(@RequestBody ServiceOne serviceOne) {
		
		services.put(serviceOne.getName(), serviceOne);
		return services.get(serviceOne.getName());
	}
}
