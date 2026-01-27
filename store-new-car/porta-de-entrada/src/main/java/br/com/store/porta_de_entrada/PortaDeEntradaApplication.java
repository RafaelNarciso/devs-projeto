package br.com.store.porta_de_entrada;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class PortaDeEntradaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortaDeEntradaApplication.class, args);
	}

}
