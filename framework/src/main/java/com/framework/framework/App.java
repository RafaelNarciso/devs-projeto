package com.framework.framework;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);

        //SpringApplicationBuilder builder = new SpringApplicationBuilder(App.class);
        //builder.run(args);
       // builder.bannerMode(Banner.Mode.OFF);
        //ConfigurableApplicationContext context = builder.context();

        //var produto = context.getBean("produto");


        //builder.profiles("produção");




    }
}
