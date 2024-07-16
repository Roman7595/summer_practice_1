package org.example.practice.services.implementations;

import org.example.practice.DTO.ProbableRiskDTO;
import org.example.practice.DTO.RiskDTO;
import org.example.practice.entities.Risk;
import org.example.practice.repositories.*;
import org.example.practice.services.interfaces.GetProbableRisksDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetProbableRisksDomainServiceImpl implements GetProbableRisksDomainService {
    @Autowired
    private RiskRepository riskRepository;

    @Autowired
    private PaymentRepository paymentRepository;
    @Override
    public List<ProbableRiskDTO> getAccurateClientsByRisks() {
        List<Risk> allRisks = riskRepository.findAll();
        int i = 0;
        List<ProbableRiskDTO> result = new ArrayList<>();
        for (Risk risk:allRisks) {
            RiskDTO riskDTO = new RiskDTO(risk.getId(),risk.getName(),risk.getDefaultRisk());
            int paymentCount = paymentRepository.getWhereRisk(risk).size();
            result.add(new ProbableRiskDTO(riskDTO, paymentCount));
            i++;
        }


        return result;
    }
}
