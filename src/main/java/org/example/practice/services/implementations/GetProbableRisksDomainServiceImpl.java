package org.example.practice.services.implementations;

import org.example.practice.DTO.ProbableRiskDTO;
import org.example.practice.entities.Risk;
import org.example.practice.repositories.*;
import org.example.practice.services.interfaces.GetProbableRisksDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProbableRisksDomainServiceImpl implements GetProbableRisksDomainService {
    @Autowired
    private RiskRepository riskRepository;

    @Autowired
    private PaymentRepository paymentRepository;
    @Override
    public ProbableRiskDTO getAccurateClientsByRisks() {
        List<Risk> allRisks = riskRepository.findAll();
        int[] paymentCount = new int[allRisks.size()];
        int i = 0;
        for (Risk risk:allRisks) {
            paymentCount[i] = paymentRepository.getWhereRisk(risk).size();
            i++;
        }
        return new ProbableRiskDTO(allRisks, paymentCount);
    }
}
