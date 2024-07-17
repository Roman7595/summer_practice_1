package org.example.practice.DTO.toAdd;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class PaymentToAddDTO {
    @NotNull(message = "contract id is missing")
    public int contractId;
    @NotNull(message = "risk id is missing")
    public int riskId;
    @NotNull(message = "date is missing")
    public Date date;
    @NotNull(message = "payment sum is missing")
    public float paymentSum;

    public PaymentToAddDTO(int contractId, int riskId, Date date, float paymentSum) {
        this.contractId = contractId;
        this.riskId = riskId;
        this.date = date;
        this.paymentSum = paymentSum;
    }
}
