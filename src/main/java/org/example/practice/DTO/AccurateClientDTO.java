package org.example.practice.DTO;

public class AccurateClientDTO {

    public RiskDTO risk;
    public ClientDTO bestClient;
    public float accuracyCount;

    public AccurateClientDTO(RiskDTO risk, ClientDTO bestClient, float accuracyCount) {
        this.risk = risk;
        this.bestClient = bestClient;
        this.accuracyCount = accuracyCount;
    }
}
