package com.estudos.car.carro.model;

import java.math.BigDecimal;

public class Motor {
    private String modelo;
    private Integer cavalos;
    private double cilindros;
    private BigDecimal litragem;
    private TipoMotor tipo;


    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getCavalos() {
        return cavalos;
    }

    public void setCavalos(Integer cavalos) {
        this.cavalos = cavalos;
    }

    public double getCilindros() {
        return cilindros;
    }

    public void setCilindros(double cilindros) {
        this.cilindros = cilindros;
    }

    public BigDecimal getLitragem() {
        return litragem;
    }

    public void setLitragem(BigDecimal litragem) {
        this.litragem = litragem;
    }

    public TipoMotor getTipo() {
        return tipo;
    }

    public void setTipo(TipoMotor tipo) {
        this.tipo = tipo;
    }

@Override
public String toString() {
    return "Motor 🚗🔥 " +
            "modelo = " + modelo + " 🎨 " +
            ", cavalos = " + cavalos + " 🐎 " +
            ", cilindros = " + cilindros + "  🔩  " +
            ", litragem = " + litragem + "  🧪 " +
            ", tipo = " + tipo + " ⚙️    " +
            '}';
}
}
