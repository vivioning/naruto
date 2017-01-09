package com.vivion.naruto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by Mr.vivion on 2017/1/8.
 */


@Configuration
@SpringBootApplication
@ComponentScan(
        basePackages = {"com.vivion.naruto"}
)
@ImportResource(locations={"classpath*:applicationContext-database.xml"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
