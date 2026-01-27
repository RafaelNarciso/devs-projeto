package br.com.autoparts.autoparts.tratamentoexception.error;

import java.time.LocalDate;

public class ErrorMenssage {

    private String titulo;
    private Integer status;
    private String mensagemDesenvolvedor;
    private LocalDate dataHora;


    public ErrorMenssage(String titulo, Integer status, String mensagemDesenvolvedor, LocalDate dataHora) {
        this.titulo = titulo;
        this.status = status;
        this.mensagemDesenvolvedor = mensagemDesenvolvedor;
        this.dataHora = dataHora;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMensagemDesenvolvedor() {
        return mensagemDesenvolvedor;
    }

    public void setMensagemDesenvolvedor(String mensagemDesenvolvedor) {
        this.mensagemDesenvolvedor = mensagemDesenvolvedor;
    }

    public LocalDate getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDate dataHora) {
        this.dataHora = dataHora;
    }
}
