package com.framework.framework.todos;

import com.zaxxer.hikari.util.DriverDataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;

public class ExemploInjecaoDepencia {

    public static void main(String[] args) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:testdb");
        dataSource.setUsername("sa");
        dataSource.setPassword("");

        Connection conection = dataSource.getConnection();

        System.out.println("DataSource configurado: " + dataSource);
    }
}
