package com.sky.tempest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TempestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TempestApplication.class, args);
	}
}
