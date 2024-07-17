package org.example.practice.controller;

import org.example.practice.DTO.ProbableRiskDTO;
import org.example.practice.DTO.RiskDTO;
import org.example.practice.services.interfaces.RiskDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/risks")
public class RiskController {
    @Autowired
    RiskDomainService riskDomainService;

    @GetMapping("/get_probable_risks")
    List<ProbableRiskDTO> getProbableRisks(){
        return riskDomainService.getProbableRisks();
    }

    @GetMapping("/")
    List<RiskDTO> getAll(){
        return riskDomainService.getAll();
    }

    @GetMapping("/{id}")
    RiskDTO one(@PathVariable Integer id){
        return riskDomainService.getById(id);
    }
}
