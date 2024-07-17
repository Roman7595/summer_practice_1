package org.example.practice.controller;

import org.example.practice.DTO.AutoDTO;
import org.example.practice.DTO.ContractDTO;
import org.example.practice.DTO.toAdd.ContractToAddDTO;
import org.example.practice.services.interfaces.ContractDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contracts")
public class ContractController {
    @Autowired
    ContractDomainService contractDomainService;
    @PostMapping("/")
    int addContract(@RequestBody ContractToAddDTO contract){
        return contractDomainService.addContract(contract);
    }

    @GetMapping("/")
    List<ContractDTO> getAll(){
        return contractDomainService.getAll();
    }

    @GetMapping("/{id}")
    ContractDTO one(@PathVariable Integer id){
        return contractDomainService.getById(id);
    }
}
