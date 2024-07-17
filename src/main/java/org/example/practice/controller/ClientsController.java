package org.example.practice.controller;

import org.example.practice.DTO.AccurateClientDTO;
import org.example.practice.DTO.ClientDTO;
import org.example.practice.DTO.toAdd.ClientToAddDTO;
import org.example.practice.services.interfaces.ClientDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/clients")
public class ClientsController {
    @Autowired
    ClientDomainService clientDomainService;

    @GetMapping("/get_accurate_clients")
    List<AccurateClientDTO> getAccurateClients(){
        return clientDomainService.getAccurateClientsByRisks();
    }

    @PostMapping("/")
    ClientDTO addClient(@RequestBody ClientToAddDTO clientToAddDTO){
        return clientDomainService.addClient(clientToAddDTO);
    }

    @GetMapping("/")
    List<ClientDTO> getAll(){
        return clientDomainService.getAll();
    }
    @GetMapping("/{id}")
    ClientDTO one(@PathVariable Integer id){
        return clientDomainService.getById(id);
    }

}
