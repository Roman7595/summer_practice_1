package org.example.practice.services.implementations;

import org.example.practice.entities.*;
import org.example.practice.exceptions.ClientNotFoundException;
import org.example.practice.repositories.*;
import org.example.practice.services.interfaces.InsurancePremiumCounterDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InsurancePremiumCounterDomainServiceImpl implements InsurancePremiumCounterDomainService {
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
    public float countInsurancePremium(int auto_id, List<Integer> risk_ids) throws ClientNotFoundException {
            Optional<Auto> auto = autoRepository.findById(auto_id);
            if (auto.isEmpty()){
                System.out.println("No auto");
                return -1;
            }

            Client client = clientRepository.getWhereAutos(auto.get());
            if (client == null){
               throw new ClientNotFoundException();
            }
            Set<Contract> allContracts = contractRepository.getWhereClient(client);
            Set<Risk> allRisks = riskRepository.getAllByIds(risk_ids);

            float riskCoefs = 0;
            for (Risk risk:
                    allRisks) {
                Set<ContractRisk> contractRisks = contractRiskRepository.getWhereContractAndRisk(allContracts, risk);
                float specialCoef;

                if (contractRisks.size() == 0){
                    specialCoef = 1;
                }else {
                    int call = contractRisks.size();
                    float cpay = 0;
                    for (ContractRisk cr : contractRisks) {
                        cpay += cr.getPayments().size();
                    }
                    specialCoef = (cpay/call);
                }

                riskCoefs += ((specialCoef + 1) * risk.getDefaultRisk());
            }
            return riskCoefs;

    };
}
