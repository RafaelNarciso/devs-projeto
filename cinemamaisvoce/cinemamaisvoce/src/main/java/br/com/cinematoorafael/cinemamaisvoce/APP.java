package br.com.cinematoorafael.cinemamaisvoce;

import br.com.cinematoorafael.cinemamaisvoce.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class APP implements CommandLineRunner {
    public static void main(String[] args) {
		SpringApplication.run(APP.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        Principal principal = new Principal();

        principal.exibeMenu();
    }
}
