package com.bookshop.catalogservice;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ConfigurationPropertiesScan
public class CatalogServiceApplication {

    @Value("${server.port}")
    private String port;
    public static void main(String[] args) {
        SpringApplication.run(CatalogServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            System.out.println("Test");
            System.out.println(port);

        };
    }
}
