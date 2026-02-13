package br.com.cinematoorafael.cinemamaisvoce.principal;

import br.com.cinematoorafael.cinemamaisvoce.model.DadosSeries;
import br.com.cinematoorafael.cinemamaisvoce.model.DadosTemporada;
import br.com.cinematoorafael.cinemamaisvoce.model.Serie;
import br.com.cinematoorafael.cinemamaisvoce.service.ConsumoAPI;
import br.com.cinematoorafael.cinemamaisvoce.service.ConverteDados;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private final String  ENDERECO ="https://www.omdbapi.com/?t=";
    private final String  API_KEY ="&apikey=d0bc9998";
    private ConsumoAPI consumo = new ConsumoAPI();
    private ConverteDados conversor = new ConverteDados();

    private List<DadosSeries> dadosSeries = new ArrayList<>();


    public void exibeMenu(){
        var opcao = -1;
        while(opcao != 0){
            System.out.println("""
                    1 - Buscar séries
                    2 - buscar episodios
                    3 - listar séries buscada
                    0 - Sair
                    """);

            opcao = leitura.nextInt();
            leitura.nextLine();


            switch (opcao){
                case 1  -> {buscarSerieWeb();break;}
                case 2  -> {buscarEpisodioPorSerie();break;}
                case 3  -> {listarSeriesBuscadas();break;}
                case 0  -> {System.out.println("Saindo ....");break;}
                default -> System.out.println("Opção Inválida ");
            }



        }

    }

    private void buscarSerieWeb(){
        DadosSeries dados = getDadosSerie();
        dadosSeries.add(dados);
        System.out.println(dados);
    }

    private DadosSeries getDadosSerie() {
        System.out.println("Digite o nome da Série para busca");
        var nomeSerie = leitura.nextLine();
        var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ","+"));
        DadosSeries dados = conversor.obterDados(json,DadosSeries.class);
        return dados;

    }

    private void buscarEpisodioPorSerie(){
        DadosSeries dadosSeries = getDadosSerie();
        List<DadosTemporada> temporadas = new ArrayList<>();

        for (int i = 0; i <= dadosSeries.totalTemporadas(); i++) {
            var json = consumo.obterDados(ENDERECO + dadosSeries.titulo().replace(" ","+"));
            DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
            temporadas.add(dadosTemporada);
        }
        temporadas.forEach(System.out::println);

    }


    private void listarSeriesBuscadas() {
        List<Serie> series = new ArrayList<>();
        series = dadosSeries.stream()
                .map(d -> new Serie(d)).collect(Collectors.toList());

        series.stream().sorted(Comparator.comparing(Serie::getGenero)).forEach(System.out::println);

    }


}
