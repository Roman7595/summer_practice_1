package org.example.practice.controller;

import org.example.practice.DTO.AccurateClientDTO;
import org.example.practice.services.interfaces.GetAccurateClientsByRisksDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/clients")
public class ClientsRepository {
    @Autowired
    GetAccurateClientsByRisksDomainService getAccurateClientsByRisksDomainService;

    @GetMapping("/get_accurate_clients")
    List<AccurateClientDTO> getAccurateClients(){
        return getAccurateClientsByRisksDomainService.getAccurateClientsByRisks();
    }

}
