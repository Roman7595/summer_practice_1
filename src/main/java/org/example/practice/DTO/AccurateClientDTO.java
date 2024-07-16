package org.example.practice.DTO;

import org.example.practice.entities.Client;

public class AccurateClientDTO {

    public RiskDTO risk;
    public ClientDTO bestClient;
    public int accuracyCount;

    public AccurateClientDTO(RiskDTO risk, ClientDTO bestClient, int accuracyCount) {
        this.risk = risk;
        this.bestClient = bestClient;
        this.accuracyCount = accuracyCount;
    }
}
