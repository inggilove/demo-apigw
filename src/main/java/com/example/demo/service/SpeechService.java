package com.example.demo.service;

import java.net.URI;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class SpeechService {
	private final RestTemplate restTemplate;
	
	public SpeechService(RestTemplate rest) {
		this.restTemplate = rest;
	}
	
	@HystrixCommand(fallbackMethod = "reliableEcho")
	public String echo() {
		URI uri = URI.create("http://35.200.40.38:3000/echo/test");
		
		return this.restTemplate.getForObject(uri, String.class);
	}
	
	public String reliableEcho() {
		return "{result: 200, msg: 'echo on API Gateway'}";
	}
}
