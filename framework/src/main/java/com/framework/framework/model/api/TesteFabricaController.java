package com.framework.framework.model.api;

import com.framework.framework.model.*;
import com.framework.framework.model.cofiguration.ToyotaCross;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carros")
public class TesteFabricaController {

    @Autowired
    @Qualifier("motorEletrico")
    private Motor motorEletrico;

    @PostMapping
    public CarroStatus ligarCarro(@RequestBody Chave chave) {
        var carro = new HondaHRV(motorEletrico);
        return carro.darIgnicao(chave);
    }

    @GetMapping
    public void obterCarroToyota(@Qualifier("motorTurbo") Motor motorTurbo) {
        var carroToyota = new ToyotaCross(motorTurbo);
        System.out.println("Carro Toyota criado: "
                + carroToyota.getModelo()
                + " com motor " +
                carroToyota.getMotor().getModelo());
    }

}
