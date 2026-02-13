package br.com.cinematoorafael.cinemamaisvoce.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Getter;
import lombok.Setter;

import java.time.DateTimeException;
import java.time.LocalDate;

@Getter
@Setter
public class Episodio {

    private Integer temporada;
    private String titulo;
    private Integer numeroEpsodio;
    private Double avalicao;
    private LocalDate dataLancamento;



    public Episodio(Integer numerotemporada, DadosEpisodio dadosEpisodio) {
        this.temporada = numerotemporada;
        this.titulo = dadosEpisodio.titulo();
        this.numeroEpsodio = dadosEpisodio.numero();

        try{
            this.avalicao =Double.valueOf( dadosEpisodio.avalicao());
        } catch (NumberFormatException e) {
            this.avalicao = 0.0;
        }
        try{
            this.dataLancamento =LocalDate.parse(dadosEpisodio.dataLancamento());
        }catch (DateTimeException ex){
            this.dataLancamento = null;
        }
    }



    @Override
    public String toString() {
        return """
        📺 Episódio
        ─────────────────────
        🎬 Título        : %s
        📦 Temporada     : %d
        🔢 Episódio nº   : %d
        ⭐ Avaliação     : %s
        📅 Lançamento    : %s
        """.formatted(
                titulo,
                temporada,
                numeroEpsodio,
                avalicao,
                dataLancamento
        );
    }


}
