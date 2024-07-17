package org.example.practice.controller;

import org.example.practice.DTO.AccurateClientDTO;
import org.example.practice.DTO.ClientToAddDTO;
import org.example.practice.services.interfaces.ClientDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/clients")
public class ClientsRepository {
    @Autowired
    ClientDomainService clientDomainService;

    @GetMapping("/get_accurate_clients")
    List<AccurateClientDTO> getAccurateClients(){
        return clientDomainService.getAccurateClientsByRisks();
    }

    @PostMapping("/add")
    int addClient(@RequestBody ClientToAddDTO clientToAddDTO){
        
    }

}
