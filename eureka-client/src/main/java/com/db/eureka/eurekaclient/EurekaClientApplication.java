package com.db.eureka.eurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = "com.db.eureka.*")
public class EurekaClientApplication {

	public static void main(String[] args) {

		System.out.println("INSIDE MAIN");
		SpringApplication.run(EurekaClientApplication.class, args);
	}

	@Configuration
	class Config {

		@LoadBalanced
		@Bean
		public RestTemplate restTemplate() {

			System.out.println("***Inside Configuration***");
			return new RestTemplate();
		}
	}

}
