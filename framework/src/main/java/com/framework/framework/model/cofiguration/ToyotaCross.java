package com.framework.framework.model.cofiguration;

import com.framework.framework.model.Carro;
import com.framework.framework.model.Montadora;
import com.framework.framework.model.Motor;

import java.awt.*;

public class ToyotaCross extends Carro {

    public ToyotaCross(Motor motor) {
        super(motor);
        this.setModelo("Toyota Cross");
        this.setMontadora(Montadora.TOYOTA);
        this.setCor(Color.BLUE);
    }


}
