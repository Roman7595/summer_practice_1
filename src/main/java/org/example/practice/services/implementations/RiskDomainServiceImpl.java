package org.example.practice.services.implementations;

import org.example.practice.DTO.ProbableRiskDTO;
import org.example.practice.DTO.RiskDTO;
import org.example.practice.entities.Risk;
import org.example.practice.exceptions.RiskNotFoundException;
import org.example.practice.repositories.interfaces.*;
import org.example.practice.services.interfaces.RiskDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RiskDomainServiceImpl implements RiskDomainService {
    @Autowired
    private RiskRepository riskRepository;

    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private ContractRepository contractRepository;
    @Override
    public List<ProbableRiskDTO> getAccurateClientsByRisks() {
        List<Risk> allRisks = riskRepository.getAll();
        int i = 0;
        List<ProbableRiskDTO> result = new ArrayList<>();
        for (Risk risk:allRisks) {
            RiskDTO riskDTO = new RiskDTO(risk.getId(),risk.getName(),risk.getDefaultRisk());

            int contractCount = contractRepository.getWhereRisk(risk).size();
            int paymentCount = paymentRepository.getWhereRisk(risk).size();
            float probability = (float) paymentCount/contractCount;

            result.add(new ProbableRiskDTO(riskDTO, probability));
            i++;
        }
        return result;
    }
    @Override
    public List<RiskDTO> getAll(){
        List<Risk> risks = riskRepository.getAll();
        List<RiskDTO> riskDTOs = new ArrayList<>();
        for (Risk risk:risks) {
            riskDTOs.add(new RiskDTO(risk.getId(),risk.getName(),risk.getDefaultRisk()));
        }
        return riskDTOs;
    }
    @Override
    public RiskDTO getById(int id){
        Optional<Risk> risk = riskRepository.getById(id);
        if(risk.isEmpty()){
            throw new RiskNotFoundException();
        }
        return new RiskDTO(risk.get().getId(),risk.get().getName(),risk.get().getDefaultRisk());

    }
}
