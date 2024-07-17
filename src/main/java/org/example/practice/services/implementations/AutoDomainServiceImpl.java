package org.example.practice.services.implementations;

import org.example.practice.DTO.AutoDTO;
import org.example.practice.DTO.toAdd.AutoToAddDTO;
import org.example.practice.entities.Auto;
import org.example.practice.entities.Client;
import org.example.practice.exceptions.AutoAlreadyExistsException;
import org.example.practice.exceptions.AutoNotFoundException;
import org.example.practice.exceptions.ClientNotFoundException;
import org.example.practice.exceptions.InvalidAutoNumberException;
import org.example.practice.repositories.interfaces.*;
import org.example.practice.services.interfaces.AutoDomainService;
import org.example.practice.utils.RegEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AutoDomainServiceImpl implements AutoDomainService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AutoRepository autoRepository;
    @Override
    public AutoDTO addAuto(AutoToAddDTO autoDTO) {
        if (!(RegEx.isValidAutoNumber(autoDTO.number))){
            throw new InvalidAutoNumberException();
        }
        List<Auto> autos = autoRepository.getAll();
        for (Auto auto:autos) {
            if(auto.getNumber().equals(autoDTO.number)){
                throw new AutoAlreadyExistsException();
            }
        }

        Optional<Client> client = clientRepository.findById(autoDTO.clientId);
        if (client.isEmpty()){
            throw new ClientNotFoundException();
        }

        Auto auto = new Auto(autoDTO.number,autoDTO.brand,autoDTO.model,autoDTO.price,client.get());
        autoRepository.save(auto);
        return new AutoDTO(auto.getId(),auto.getNumber(),auto.getBrand(),auto.getModel(),auto.getPrice(),auto.getClient().getId());
    }

    @Override
    public List<AutoDTO> getAll(){
        List<Auto> autos = autoRepository.getAll();
        List<AutoDTO> autoDTOs = new ArrayList<>();
        for (Auto auto:autos) {
            autoDTOs.add(new AutoDTO(auto.getId(), auto.getNumber(),auto.getBrand(),auto.getModel(), auto.getPrice(), auto.getClient().getId()));
        }
        return autoDTOs;
    }

    public AutoDTO getById(int id){
        Optional<Auto> auto = autoRepository.findById(id);
        if(auto.isEmpty()){
            throw new AutoNotFoundException();
        }
        return new AutoDTO(auto.get().getId(), auto.get().getNumber(), auto.get().getBrand(), auto.get().getModel(), auto.get().getPrice(), auto.get().getClient().getId());
    }

}
