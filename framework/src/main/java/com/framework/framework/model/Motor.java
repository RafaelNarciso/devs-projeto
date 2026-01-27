package com.framework.framework.model;

public class Motor {

    private String modelo;
    private Integer potencia;
    private Integer cilindrada;
    private Double litragem;
    private TipoMotor tipoMotor;

    //#region Getters and Setters
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getPotencia() {
        return potencia;
    }

    public void setPotencia(Integer potencia) {
        this.potencia = potencia;
    }

    public Integer getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(Integer cilindrada) {
        this.cilindrada = cilindrada;
    }

    public Double getLitragem() {
        return litragem;
    }

    public void setLitragem(Double litragem) {
        this.litragem = litragem;
    }

    public TipoMotor getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(TipoMotor tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    //#endregion


    @Override
    public String toString() {
        return "🚗 Motor" +
                "⚙️ modelo='" + modelo  +
                "💪 potência=" + potencia +
                "🔩 cilindrada=" + cilindrada +
                "🛢️ litragem=" + litragem +
                "🔧 tipoMotor=" + tipoMotor
                ;
    }

}
