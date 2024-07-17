package org.example.practice.services.implementations;

import org.example.practice.DTO.AccurateClientDTO;
import org.example.practice.DTO.ClientDTO;
import org.example.practice.DTO.RiskDTO;
import org.example.practice.entities.*;
import org.example.practice.repositories.*;
import org.example.practice.services.interfaces.ClientDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class GetAccurateClientsByRisksDomainServiceImpl implements ClientDomainService {
    @Autowired
    private ContractRiskRepository contractRiskRepository;
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private RiskRepository riskRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public List<AccurateClientDTO> getAccurateClientsByRisks() {
        List<Client> clients = clientRepository.findAll();
        if (clients.size() == 0) {
            System.out.println("No Clients");
            return null;
        }

        List<Risk> allRisks = riskRepository.findAll();
        List<AccurateClientDTO> result = new ArrayList<>();
        for (Client client:clients) {
            int i = 0;
            for (Risk risk:allRisks) {
                Set<Payment> payments = paymentRepository.getWhereClientAndRisk(client, risk);
                Set<ContractRisk> contracts = contractRiskRepository.getWhereClientAndRisk(client, risk);
                int paymentCount;
                int accuracyCount;
                int contractCount;
                if (payments == null){
                    paymentCount = 0;
                }else {
                    paymentCount = payments.size();
                }

                if (contracts == null ){
                    contractCount = 0;
                }else{
                    contractCount = contracts.size();
                }
                if (contractCount == 0) {
                    accuracyCount = Integer.MAX_VALUE;
                }else {
                    accuracyCount = paymentCount / contractCount;
                }

                RiskDTO riskDto = new RiskDTO(risk.getId(),risk.getName(),risk.getDefaultRisk());
                ClientDTO clientDTO = new ClientDTO(client.getId(),client.getFirstName(),client.getMiddleName(),client.getLastName(),client.getPassportNumberAndSeries());

                AccurateClientDTO currentClient = new AccurateClientDTO(riskDto, clientDTO, accuracyCount);

                if (result.size() < allRisks.size()){
                    result.add(currentClient);

                }else if (accuracyCount < result.get(i).accuracyCount){
                    result.set(i, currentClient);
                }

                i++;
            }
        }
        return result;
    }
}
