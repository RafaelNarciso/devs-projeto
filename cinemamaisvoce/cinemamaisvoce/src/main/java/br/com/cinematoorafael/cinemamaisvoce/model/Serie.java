package br.com.cinematoorafael.cinemamaisvoce.model;


import br.com.cinematoorafael.cinemamaisvoce.service.ConsultaChatGPT;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.OptionalDouble;

@Getter
@Setter

public class Serie {

    private String titulo;
    private Integer totalTemporadas;
    private Double avaliacao;
    private Categoria genero;
    private String atores;
    private String poster;
    private String sinopse;

    public Serie (DadosSeries dadosSeries){
        this.titulo = dadosSeries.titulo();
        this.totalTemporadas = dadosSeries.totalTemporadas();
        this.avaliacao = OptionalDouble.of(Double.valueOf(dadosSeries.avaliacao())).orElse(0);
        this.genero = Categoria.fromString(dadosSeries.genero().split(",")[0].trim());
        this.atores = dadosSeries.atores();
        this.poster = dadosSeries.poster();
        this.sinopse = ConsultaChatGPT.obterTraducao( dadosSeries.sinopse()).trim();
    }

    @Override
    public String toString() {
        return "===== SÉRIE =====\n" +
                "Gênero: " + genero + "\n" +
                "Título: " + titulo + "\n" +
                "Total de Temporadas: " + totalTemporadas + "\n" +
                "Avaliação: " + avaliacao + "\n" +
                "Atores: " + atores + "\n" +
                "Poster: " + poster + "\n" +
                "Sinopse: " + sinopse + "\n";
    }

}
