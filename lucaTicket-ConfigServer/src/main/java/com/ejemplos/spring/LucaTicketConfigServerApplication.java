package com.ejemplos.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class LucaTicketConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LucaTicketConfigServerApplication.class, args);
	}

}
