package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Springcommunication3Application 
{
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
	public static void main(String[] args)
	{
		SpringApplication.run(Springcommunication3Application.class, args);
		System.out.println("Application 3 is running  with WebCLient .... !");
	}

}
