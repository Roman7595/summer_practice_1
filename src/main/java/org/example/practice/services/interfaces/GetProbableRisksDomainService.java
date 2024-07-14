package org.example.practice.services.interfaces;

import org.example.practice.entities.Risk;

import java.util.Set;

public interface GetProbableRisksDomainService {
    Set<Risk> getAccurateClientsByRisks();
}
