package br.com.tabelafipes.tabelafipe.model;

import br.com.tabelafipes.tabelafipe.service.ConsumoAPI;
import br.com.tabelafipes.tabelafipe.service.ConverteDados;

import java.util.Scanner;

public class PesquisaVeiculo {

    private Scanner leitura = new Scanner(System.in);
    private final String ENDERECO ="https://parallelum.com.br/fipe/api/v1/";
    private final String MARCAS = "/marcas";
    private ConsumoAPI consumo = new ConsumoAPI();

    private ConverteDados conversor = new ConverteDados();


    public void pesquisar(String tipoVeiculo) {
        boolean continuar = true;

        while (continuar) {

            String urlMarcas = ENDERECO + tipoVeiculo + MARCAS;
            System.out.println(urlMarcas);

            System.out.print("Informe o código da marca: ");
            int codigoMarca = leitura.nextInt();
            leitura.nextLine();

            String urlModelos = urlMarcas +"/"+ codigoMarca + "/modelos";
            System.out.println(urlModelos);

            System.out.print("Informe o código do modelo: ");
            String codigoModelo = leitura.nextLine().trim();

            String urlAnos = urlModelos +"/" + codigoModelo + "/anos";
            System.out.println(urlAnos);

            System.out.println("Informe o codido para descubre o valor :");
            String urlPrecos = leitura.nextLine().trim();

            String urlPreco = urlAnos+"/"+urlPrecos;


            System.out.println(urlPreco);

            System.out.println("""
                Deseja realizar uma nova pesquisa?
                1 - Sim
                2 - Não
                """);

            int opcao = leitura.nextInt();
            leitura.nextLine();

            continuar = opcao == 1;
        }
    }


}
