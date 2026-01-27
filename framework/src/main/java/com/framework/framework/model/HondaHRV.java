package com.framework.framework.model;

import java.awt.*;

public class HondaHRV extends Carro{

    public HondaHRV(Motor motor) {
        super(motor);
        this.setModelo("Honda HR-V");
        this.setMontadora(Montadora.HONDA);
        this.setCor(Color.BLUE);
    }


}
