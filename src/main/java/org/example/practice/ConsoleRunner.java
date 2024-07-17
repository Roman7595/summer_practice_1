package org.example.practice;

import org.example.practice.services.interfaces.ContractDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleRunner implements CommandLineRunner {
    @Autowired
    private ContractDomainService counter;
    @Override
    public void run(String... strings) throws Exception {
   }


}
