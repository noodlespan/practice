package com.example.readapplicationproperties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(MailProperties.class)
public class ReadApplicationPropertiesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReadApplicationPropertiesApplication.class, args);
    }

}
