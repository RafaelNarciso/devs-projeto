package com.estudos.car.carro.model;

public class JeepRenegade extends Carro{


    public JeepRenegade(Motor motor) {
        super(motor);
        setModelo("Jeep Renegade");
        setCor(new java.awt.Color(0, 0, 130)); // preto
        setMontadora(Montadora.JEEP);

    }

}
