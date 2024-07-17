package org.example.practice.services.interfaces;

import org.example.practice.DTO.ContractDTO;
import org.example.practice.DTO.toAdd.ContractToAddDTO;

import java.util.List;
import java.util.Optional;


public interface ContractDomainService {
    public int addContract(ContractToAddDTO contract);
    public List<ContractDTO> getAll();
    public ContractDTO getById(int id);
}
