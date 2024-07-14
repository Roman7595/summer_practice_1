package org.example.practice.services.implementations;

import org.example.practice.DTO.AccurateClientDTO;
import org.example.practice.entities.*;
import org.example.practice.repositories.*;
import org.example.practice.services.interfaces.GetAccurateClientsByRisksDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service
public class GetAccurateClientsByRisksDomainServices implements GetAccurateClientsByRisksDomainService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private RiskRepository riskRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public AccurateClientDTO getAccurateClientsByRisks() {
        List<Client> clients = clientRepository.findAll();
        if (clients == null) {
            System.out.println("No Clients");
            return null;
        }
        List<Risk> allRisks = riskRepository.findAll();
        Client[] minRiskClient = new Client[allRisks.size()];
        int[] minRiskCount = new int[allRisks.size()];
        Arrays.fill(minRiskCount, Integer.MAX_VALUE);
        for (Client client:clients) {
            for (Risk risk:
                    allRisks) {
                Set<Payment> payments = paymentRepository.getWhereClientAndRisk(client, risk);
                int currentRiskNumber = allRisks.indexOf(risk);
                int paymentCount;
                if (payments == null){
                    paymentCount = 0;
                }else {
                    paymentCount = payments.size();
                }
                if (paymentCount < minRiskCount[currentRiskNumber]){
                    minRiskClient[currentRiskNumber] = client;
                    minRiskCount[currentRiskNumber] = paymentCount;
                }
            }
        }
        return new AccurateClientDTO(allRisks, minRiskClient, minRiskCount);
    }
}
