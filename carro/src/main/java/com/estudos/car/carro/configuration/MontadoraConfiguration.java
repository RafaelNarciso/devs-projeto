package com.estudos.car.carro.configuration;

import com.estudos.car.carro.model.Motor;
import com.estudos.car.carro.model.TipoMotor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.math.BigDecimal;

@Configuration
public class MontadoraConfiguration {

    @Bean(name = "motorAspirado")
    @Primary
    public Motor motorAspirado(){
        var motor = new Motor();
        motor.setCavalos(99);
        motor.setCilindros(8);
        motor.setModelo("Renegade");
        motor.setCilindros(1.8);
        motor.setLitragem(BigDecimal.valueOf(50));
        motor.setTipo(TipoMotor.ASPIRADO);
        return motor;
    }
    @Bean(name = "motorEletrico")
    public Motor motorEletrico(){
        var motor = new Motor();
        motor.setCavalos(158);
        motor.setCilindros(3);
        motor.setModelo("jeep commander");
        motor.setCilindros(1.3);
        motor.setTipo(TipoMotor.ELETRICO);
        return motor;
    }

    @Bean(name = "motorTurbo")
    public Motor motorTurbo(){
        var motor = new Motor();
        motor.setCavalos(180);
        motor.setCilindros(3);
        motor.setModelo("Compass");
        motor.setCilindros(1.3);
        motor.setLitragem(BigDecimal.valueOf(50));
        motor.setTipo(TipoMotor.TURBO);
        return motor;
    }



}
