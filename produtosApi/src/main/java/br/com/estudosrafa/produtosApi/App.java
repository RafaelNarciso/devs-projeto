package br.com.estudosrafa.produtosApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class App {

    @GetMapping("/ola")
    public String  olaMundo() {
        return "Olá Mundo!";
    }

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}



}
