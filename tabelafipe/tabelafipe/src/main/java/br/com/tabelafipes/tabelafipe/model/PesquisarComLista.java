package br.com.tabelafipes.tabelafipe.model;

import br.com.tabelafipes.tabelafipe.service.ConsumoAPI;
import br.com.tabelafipes.tabelafipe.service.ConverteDados;

import java.util.List;
import java.util.Scanner;

public class PesquisarComLista {
        private Scanner leitura = new Scanner(System.in);
        private final String ENDERECO = "https://parallelum.com.br/fipe/api/v1/";
        private final String MARCAS = "/marcas";
        private ConsumoAPI consumo = new ConsumoAPI();
        private ConverteDados conversor = new ConverteDados();




        public void pesquisar(String tipoVeiculo) {

            boolean continuar = true;
            while (continuar) {

                // ===== MARCAS =====
                String urlMarcas = ENDERECO + tipoVeiculo + MARCAS;
                var jsonMarcas = consumo.obterDados(urlMarcas);

                List<Marca> marcas = conversor.obterLista(jsonMarcas, Marca.class);
                marcas.forEach(m ->
                        System.out.println("Código: " + m.codigo() + " | Marca: " + m.nome())
                );

                System.out.print("\nInforme o código da marca: ");
                String codigoMarca = leitura.nextLine();

                // ===== MODELOS =====
                String urlModelos = urlMarcas + "/" + codigoMarca + "/modelos";
                var jsonModelos = consumo.obterDados(urlModelos);

                ModeloResposta modelosResposta = conversor.obterDados(jsonModelos, ModeloResposta.class);

                modelosResposta.modelos().forEach(m ->
                        System.out.println("Código: " + m.codigo() + " | Modelo: " + m.nome())
                );

                System.out.print("\nInforme o código do modelo: ");
                String codigoModelo = leitura.nextLine();

                // ===== ANOS =====
                String urlAnos = urlModelos + "/" + codigoModelo + "/anos";
                var jsonAnos = consumo.obterDados(urlAnos);

                List<Ano> anos = conversor.obterLista(jsonAnos, Ano.class);
                anos.forEach(a ->
                        System.out.println("Código: " + a.codigo() + " | Ano: " + a.nome())
                );

                System.out.print("\nInforme o código do ano: ");
                String codigoAno = leitura.nextLine();

                // ===== PREÇO =====
                String urlPreco = urlAnos + "/" + codigoAno;
                var jsonPreco = consumo.obterDados(urlPreco);

                ValorFipe valorFipe = conversor.obterDados(jsonPreco, ValorFipe.class);

                System.out.println("\nValor FIPE:");
                System.out.println(valorFipe);


                System.out.println("""
                        Deseja realizar uma nova pesquisa?
                        1 - Sim
                        2 - Não
                        """);

                int opcao = leitura.nextInt();
                leitura.nextLine();

                continuar = opcao == 1;
                if (!continuar){
                    System.out.println("Encerrando app");
                }
            }
        }
    }



