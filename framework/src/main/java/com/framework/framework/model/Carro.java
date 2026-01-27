package com.framework.framework.model;

import java.awt.*;

public class Carro {
    private String modelo;
    private Color cor;
    private Motor motor;
    private Montadora  montadora;

    //#region Constructor
    public Carro( Motor motor) {
        this.motor = motor;
    }
    //#endregion

    //#region Getters and Setters

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Color getCor() {
        return cor;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public Montadora getMontadora() {
        return montadora;
    }

    public void setMontadora(Montadora montadora) {
        this.montadora = montadora;
    }

    //#endregion

    //#region metodos
    public CarroStatus darIgnicao(Chave chave) {
        if (chave.getMontadora() != this.montadora) {
            return new CarroStatus("Carro " + this.modelo + " Chave inválida para o carro");
        }
        return new CarroStatus("carro ligado com sucesso"+motor);

    }
    //#endregion

}
