package org.example.practice.services.implementations;

import org.example.practice.DTO.AccurateClientDTO;
import org.example.practice.DTO.ClientDTO;
import org.example.practice.DTO.toAdd.ClientToAddDTO;
import org.example.practice.DTO.RiskDTO;
import org.example.practice.entities.*;
import org.example.practice.exceptions.ClientAlreadyExistsException;
import org.example.practice.exceptions.ClientNotFoundException;
import org.example.practice.exceptions.InvalidPassportException;
import org.example.practice.repositories.interfaces.*;
import org.example.practice.services.interfaces.ClientDomainService;
import org.example.practice.utils.RegEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ClientDomainServiceImpl implements ClientDomainService {
    @Autowired
    private ContractRiskRepository contractRiskRepository;
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private RiskRepository riskRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public ClientDTO addClient(ClientToAddDTO clientToAdd) throws ClientAlreadyExistsException{
        if (!(RegEx.isValidPassport(clientToAdd.passportNumberAndSeries))){
            throw new InvalidPassportException();
        }

        List<Client> allClients =  clientRepository.findAll();

        for (Client client:allClients) {
            if (client.getPassportNumberAndSeries().equalsIgnoreCase(clientToAdd.passportNumberAndSeries)){
                throw new ClientAlreadyExistsException();
            }
        }

        Client newClient = new Client(clientToAdd.firstName, clientToAdd.middleName, clientToAdd.lastName, clientToAdd.passportNumberAndSeries);
        clientRepository.save(newClient);
        return new ClientDTO(newClient.getId(), newClient.getFirstName(), newClient.getMiddleName(), newClient.getLastName(), newClient.getPassportNumberAndSeries());
    }

    @Override
    public List<AccurateClientDTO> getAccurateClientsByRisks() {
        List<Client> clients = clientRepository.findAll();
        if (clients.size() == 0) {
            System.out.println("No Clients");
            return null;
        }

        List<Risk> allRisks = riskRepository.getAll();
        List<AccurateClientDTO> result = new ArrayList<>();
        for (Client client:clients) {
            int i = 0;
            for (Risk risk:allRisks) {
                Set<Payment> payments = paymentRepository.getWhereClientAndRisk(client, risk);
                Set<ContractRisk> contracts = contractRiskRepository.getWhereClientAndRisk(client, risk);
                int paymentCount;
                float accuracyCount;
                int contractCount;

                paymentCount = payments.size();
                contractCount = contracts.size();

                if (contractCount == 0) {
                    accuracyCount = Float.MAX_VALUE;
                }else {
                    accuracyCount = (float) paymentCount / contractCount;
                }

                RiskDTO riskDto = new RiskDTO(risk.getId(),risk.getName(),risk.getDefaultRisk());
                ClientDTO clientDTO = new ClientDTO(client.getId(),client.getFirstName(), client.getMiddleName(), client.getLastName(), client.getPassportNumberAndSeries());

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
    @Override
    public List<ClientDTO> getAll(){
        List<Client> clients = clientRepository.findAll();
        List<ClientDTO> clientDTOs = new ArrayList<>();
        for (Client client:clients) {
            clientDTOs.add(new ClientDTO(client.getId(), client.getFirstName(), client.getMiddleName(), client.getLastName(), client.getPassportNumberAndSeries()));
        }
        return clientDTOs;
    }
    @Override
    public ClientDTO getById(int id){
        Optional<Client> client = clientRepository.findById(id);
        if(client.isEmpty()){
            throw new ClientNotFoundException();
        }
        return new ClientDTO(client.get().getId(),client.get().getFirstName(),client.get().getMiddleName(),client.get().getLastName(),client.get().getPassportNumberAndSeries());
    }
}
