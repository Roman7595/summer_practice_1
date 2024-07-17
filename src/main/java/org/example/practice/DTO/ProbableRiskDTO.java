package org.example.practice.DTO;

public class ProbableRiskDTO {
    public RiskDTO risk;
    public float probability;

    public ProbableRiskDTO(RiskDTO risk, float probability) {
        this.risk = risk;
        this.probability = probability;
    }
}
