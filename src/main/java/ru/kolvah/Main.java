package ru.kolvah;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by dmitriik on 19.05.2016.
 */
@SpringBootApplication(scanBasePackages = "ru.kolvah")
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
