package org.example.practice;

import org.example.practice.entities.Auto;
import org.example.practice.entities.Client;
import org.example.practice.entities.Risk;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleRunner implements CommandLineRunner {

    @Override
    public void run(String... strings) throws Exception {
        Risk risk = new Risk("Пожар", 2.3f);
        Client client = new Client("Р","Ч","М","1111111111");
        Auto auto = new Auto("1","qq","11",2.345f, client);

    }
}