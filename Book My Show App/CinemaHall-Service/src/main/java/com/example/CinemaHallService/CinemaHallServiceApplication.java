package com.example.CinemaHallService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CinemaHallServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinemaHallServiceApplication.class, args);
	}

}
