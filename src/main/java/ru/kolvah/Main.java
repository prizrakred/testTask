package ru.kolvah;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.kolvah.service.serviceImpl.EquipmentServiceImpl;

/**
 * Created by dmitriik on 19.05.2016.
 */
@SpringBootApplication(scanBasePackages = "ru.kolvah")
public class Main {

    public static void main(String[] args) {
        SpringContext.getContext().getBean(EquipmentServiceImpl.class);
        SpringApplication.run(Main.class, args);
    }
}
