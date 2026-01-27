package com.exemplo.controle_animais_ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class AnimaisMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimaisMsApplication.class, args);
	}

}
