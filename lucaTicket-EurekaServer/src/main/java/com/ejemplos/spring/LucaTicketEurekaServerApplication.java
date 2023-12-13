package com.ejemplos.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class LucaTicketEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LucaTicketEurekaServerApplication.class, args);
	}

}
