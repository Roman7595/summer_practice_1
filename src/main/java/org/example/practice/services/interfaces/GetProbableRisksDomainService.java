package org.example.practice.services.interfaces;

import org.example.practice.DTO.ProbableRiskDTO;
import org.example.practice.entities.Risk;

import java.util.Set;

public interface GetProbableRisksDomainService {
    ProbableRiskDTO getAccurateClientsByRisks();
}
