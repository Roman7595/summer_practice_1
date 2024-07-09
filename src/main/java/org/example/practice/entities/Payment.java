package org.example.practice.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="payments")
public class Payment {
    private Date date;
    private int paymentSum;
    private ContractRisk contractRisk;

    public Payment( Date date, int paymentSum, ContractRisk contractRisk) {
        this.date = date;
        this.paymentSum = paymentSum;
        this.contractRisk = contractRisk;
    }

    @Column(name="date", nullable=false)
    public  Date getDate() {
        return date;
    }

    public void setDate( Date date) {
        this.date = date;
    }

    @Column(name="payment_sum", nullable=false)
    public int getPaymentSum() {
        return paymentSum;
    }

    public void setPaymentSum(int paymentSum) {
        this.paymentSum = paymentSum;
    }

    @ManyToOne
    @JoinColumn(name="contract_risk_id", nullable=false)
    public ContractRisk getContractRisk() {
        return contractRisk;
    }

    public void setContractRisk(ContractRisk contractRisk) {
        this.contractRisk = contractRisk;
    }
}
