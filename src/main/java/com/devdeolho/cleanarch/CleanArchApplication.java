package com.devdeolho.cleanarch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
public class CleanArchApplication {

	public static void main(String[] args) {
		SpringApplication.run(CleanArchApplication.class, args);
	}

}
