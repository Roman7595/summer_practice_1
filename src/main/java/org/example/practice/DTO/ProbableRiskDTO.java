package org.example.practice.DTO;

import org.example.practice.entities.Risk;

import java.util.List;

public class ProbableRiskDTO {
    public List<Risk> risks;
    public int[] paymentCounts;

    public ProbableRiskDTO(List<Risk> risks, int[] paymentCounts) {
        this.risks = risks;
        this.paymentCounts = paymentCounts;
    }
}
