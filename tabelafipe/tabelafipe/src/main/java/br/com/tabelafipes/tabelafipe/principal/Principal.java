package br.com.tabelafipes.tabelafipe.principal;

import br.com.tabelafipes.tabelafipe.model.PesquisaVeiculo;
import br.com.tabelafipes.tabelafipe.model.PesquisarComLista;

import java.util.Scanner;
public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private PesquisaVeiculo pesquisaVeiculo = new PesquisaVeiculo();
    private PesquisarComLista pesquisa = new PesquisarComLista();

    public void exibeMenu(){
        System.out.println("\nDescubra a tabela Fipe do veiculo : \n");

        boolean menu = true;

        while (menu){
            System.out.println("Qual modelo deseja pesquisar :\n1- Carro \n2- Moto \n3- Caminhoes ");
         int escolha = leitura.nextInt();
         leitura.nextLine();
                switch (escolha) {
                    case 1 -> {pesquisaVeiculo.pesquisar("carros");}
                    case 2 -> {pesquisaVeiculo.pesquisar("motos");}
                    case 3 -> {pesquisaVeiculo.pesquisar("caminhoes");}
                    default -> {System.out.println("Opção invalida !!!");}
            }

        }
    }



    public void menuComLista() {

        boolean menu = true;

        while (menu) {
            System.out.println("""
                Qual modelo deseja pesquisar:
                1 - Carro
                2 - Moto
                3 - Caminhões
                0 - Sair
                """);


            int escolha = leitura.nextInt();
            leitura.nextLine();

            switch (escolha) {
                case 1 -> pesquisa.pesquisar("carros");
                case 2 -> pesquisa.pesquisar("motos");
                case 3 -> pesquisa.pesquisar("caminhoes");
                case 0 -> menu = false;
                default -> System.out.println("Opção inválida!");
            }
        }
    }
}
