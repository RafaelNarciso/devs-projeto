package com.framework.framework.model.cofiguration;

import com.framework.framework.model.Motor;
import com.framework.framework.model.TipoMotor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MontadoraConfiguration {

    @Bean
    public Motor motor() {
        return criarMotor("XPT0-0", 120, 4, 2.0, TipoMotor.ASPIRADO);
    }

    @Bean
    public Motor motorTurbo() {
        return criarMotor("XPT0-1 -TURBO", 200, 4, 2.0, TipoMotor.TURBO);
    }

    @Bean
    public Motor motorHibrido() {
        return criarMotor("XPT0-5 -HIBRIDO", 180, 4, 2.0, TipoMotor.HIBRIDO);
    }

    @Bean
    public Motor motorEletrico() {
        return criarMotor("XPT0-4 -ELETRICO", 150, 0, 0.0, TipoMotor.ELETRICO);
    }

    //*Método auxiliar para evitar repetição
    private Motor criarMotor(String modelo, int potencia, int cilindrada, double litragem, TipoMotor tipo) {
        var motor = new Motor();
        motor.setModelo(modelo);
        motor.setPotencia(potencia);
        motor.setCilindrada(cilindrada);
        motor.setLitragem(litragem);
        motor.setTipoMotor(tipo);
        return motor;
    }


}
