package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.example.demo.filters.pre.SimpleFilter;

@EnableZuulProxy
@SpringBootApplication
public class DemoApigwApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApigwApplication.class, args);
	}
	
	  @Bean
	  public SimpleFilter simpleFilter() {
	    return new SimpleFilter();
	  }
	  
}
