package br.com.aprendizado.modulo_01.controller;


import br.com.aprendizado.modulo_01.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;


@RestController
public class GreentingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    //localhost:8080/greeting/greeting?name=Rafa

    @RequestMapping("/greeting")
    public Greeting greenting(@RequestParam(value = "name",defaultValue = "Word") String name){
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
