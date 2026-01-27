package br.com.compras.Produto.error;


import java.time.LocalDate;

public class ErrorMenssage {
    private String titulo;
    private Integer status;
    private String mensagem;
    private LocalDate date = LocalDate.now();

    // region Construtor
    public ErrorMenssage(String titulo, Integer status, String mensagem, LocalDate date) {
        this.titulo = titulo;
        this.status = status;
        this.mensagem = mensagem;
        this.date = date;
    }
    //endregion


    // region Getters and Setters

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

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


    //endregion

}
