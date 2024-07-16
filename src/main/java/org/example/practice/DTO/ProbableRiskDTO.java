package org.example.practice.DTO;

public class ProbableRiskDTO {
    public RiskDTO risk;
    public int paymentCount;

    public ProbableRiskDTO(RiskDTO risk, int paymentCount) {
        this.risk = risk;
        this.paymentCount = paymentCount;
    }
}
