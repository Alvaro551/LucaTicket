package com.ejemplos.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LucaTicketGateway2Application {

	public static void main(String[] args) {
		SpringApplication.run(LucaTicketGateway2Application.class, args);
	}

}
