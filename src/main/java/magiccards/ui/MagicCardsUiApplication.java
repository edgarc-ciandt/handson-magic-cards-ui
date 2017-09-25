package magiccards.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MagicCardsUiApplication {
    public static void main(String[] args) {
        SpringApplication.run(MagicCardsUiApplication.class, args);
    }
}