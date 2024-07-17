package org.example.practice.services.interfaces;

import org.example.practice.DTO.ProbableRiskDTO;

import java.util.List;

public interface GetProbableRisksDomainService {
    List<ProbableRiskDTO> getAccurateClientsByRisks();
}
