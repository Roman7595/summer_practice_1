package org.example.practice.services.implementations;

import org.example.practice.entities.*;
import org.example.practice.repositories.*;
import org.example.practice.services.interfaces.InsurancePremiumCounterDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
class InsurancePremiumCounterDomainServiceImpl implements InsurancePremiumCounterDomainService {
    @Autowired
    private ContractRepository contractRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private RiskRepository riskRepository;
    @Autowired
    private ContractRiskRepository contractRiskRepository;
    @Autowired
    private AutoRepository autoRepository;
    public float countInsurancePremium(int auto_id, List<Integer> risk_ids){
            Auto auto = autoRepository.getReferenceById(auto_id);
            Client client = clientRepository.getWhereAutos(auto);

            Set<Contract> allContracts = contractRepository.getWhereClients(client);
            Set<Risk> allRisks = riskRepository.getAllByIds(risk_ids);
            float riskCoefs = 0;
            for (Risk risk:
                    allRisks) {
                Set<ContractRisk> crs = contractRiskRepository.getWhereContractAndRisk(allContracts, risk);
                float specialCoef;

                if (crs == null){
                    specialCoef = 1;
                }else {
                    int call = crs.size();
                    float cpay = 0;
                    for (ContractRisk cr : crs) {
                        cpay += cr.getPayments().size();
                    }
                    specialCoef = (cpay/call);
                }

                riskCoefs += ((specialCoef + 1) * risk.getDefaultRisk());
            }
            return riskCoefs;

    };
}
