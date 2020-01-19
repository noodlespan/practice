package com.example.springwebfluxmysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@EnableR2dbcRepositories
public class SpringWebfluxMysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWebfluxMysqlApplication.class, args);
    }

}
