package com.example.ConfigSeverService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigSeverServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigSeverServiceApplication.class, args);
	}

}
