package com.tcgplacecards.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CardsUiApplication {
    public static void main(String[] args) {
        SpringApplication.run(CardsUiApplication.class, args);
    }
}