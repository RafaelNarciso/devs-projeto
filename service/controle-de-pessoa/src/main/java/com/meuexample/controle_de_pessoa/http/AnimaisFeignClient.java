package com.meuexample.controle_de_pessoa.http;


import com.meuexample.controle_de_pessoa.shared.AnimalDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "controle-animais-ms")
public interface AnimaisFeignClient {

    @GetMapping("/api/animais/{dono}")
    List<AnimalDto> obterAnimais(@PathVariable("dono") UUID dono);
}
