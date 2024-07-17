package org.example.practice.DTO;

import java.util.Date;

public class PaymentDTO {
    public int id;
    public int contractId;
    public int riskId;
    public Date date;
    public float paymentSum;

    public PaymentDTO(int id, int contractId, int riskId, Date date, float paymentSum) {
        this.id = id;
        this.contractId = contractId;
        this.riskId = riskId;
        this.date = date;
        this.paymentSum = paymentSum;
    }
}
