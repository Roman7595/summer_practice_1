package org.example.practice.controller;

import org.example.practice.DTO.ProbableRiskDTO;
import org.example.practice.services.interfaces.GetProbableRisksDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/risks")
public class RiskController {
    @Autowired
    GetProbableRisksDomainService getProbableRisksDomainService;

    @GetMapping("/get_probable_risks")
    List<ProbableRiskDTO> getProbableRisks(){
        return getProbableRisksDomainService.getAccurateClientsByRisks();
    }
}
