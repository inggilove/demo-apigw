package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.filters.pre.SimpleFilter;
import com.example.demo.service.SpeechService;

@EnableCircuitBreaker
@EnableZuulProxy
@RestController
@SpringBootApplication
public class DemoApigwApplication {

	@Autowired
	private SpeechService speechService;
	
	@Bean
	public RestTemplate rest(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@RequestMapping("/echo") 
	public String sendEcho() {
		return speechService.echo();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApigwApplication.class, args);
	}
	
	  @Bean
	  public SimpleFilter simpleFilter() {
	    return new SimpleFilter();
	  }
	  
}
