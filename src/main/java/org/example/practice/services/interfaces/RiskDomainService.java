package org.example.practice.services.interfaces;

import org.example.practice.DTO.ProbableRiskDTO;
import org.example.practice.DTO.RiskDTO;

import java.util.List;

public interface RiskDomainService {
    public List<ProbableRiskDTO> getAccurateClientsByRisks();

    public List<RiskDTO> getAll();

    public RiskDTO getById(int id);

}
