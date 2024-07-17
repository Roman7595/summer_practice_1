package org.example.practice.services.interfaces;

import org.example.practice.DTO.AutoDTO;
import org.example.practice.DTO.toAdd.AutoToAddDTO;

import java.util.List;

public interface AutoDomainService {
    public AutoDTO addAuto(AutoToAddDTO autoDTO);
    public List<AutoDTO> getAll();
    public AutoDTO getById(int id);
}
