package com.example.demo.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

	@Bean
	public ModelMapper mapper() {
		return new ModelMapper();
	}
	
	@Bean
	RestTemplate template() {
		return new RestTemplate();
	}
}
