package com.rich.onlinegamesshop;

import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
@EntityScan(basePackages = {"com.rich.onlinegamesshop.model.views"})
public class OnlineGamesShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineGamesShopApplication.class, args);
    }

}
