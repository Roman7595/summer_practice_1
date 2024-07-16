package org.example.practice.services.interfaces;

import org.example.practice.DTO.AccurateClientDTO;

import java.util.List;


public interface GetAccurateClientsByRisksDomainService {
    List<AccurateClientDTO> getAccurateClientsByRisks();
}
