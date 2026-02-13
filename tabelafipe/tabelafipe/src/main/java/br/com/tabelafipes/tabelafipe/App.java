package br.com.tabelafipes.tabelafipe;

import br.com.tabelafipes.tabelafipe.model.PesquisaVeiculo;
import br.com.tabelafipes.tabelafipe.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App implements CommandLineRunner {

    public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}


    @Override
    public void run(String... args) throws Exception {
        Principal principal = new Principal();
        //principal.exibeMenu();

        principal.menuComLista();



    }
}
