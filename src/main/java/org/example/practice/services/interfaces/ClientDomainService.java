package org.example.practice.services.interfaces;

import org.example.practice.DTO.AccurateClientDTO;
import org.example.practice.DTO.ClientDTO;
import org.example.practice.DTO.toAdd.ClientToAddDTO;
import org.example.practice.exceptions.ClientAlreadyExistsException;

import java.util.List;


public interface ClientDomainService {
    public List<AccurateClientDTO> getAccurateClientsByRisks();
    public ClientDTO addClient(ClientToAddDTO client) throws ClientAlreadyExistsException;
    public List<ClientDTO> getAll();
    public ClientDTO getById(int id);
}
