package org.example.practice.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="payments")
public class Payment extends BaseEntity{
    private Date date;
    private float paymentSum;
    private ContractRisk contractRisk;

    public Payment( Date date, float paymentSum, ContractRisk contractRisk) {
        this.date = date;
        this.paymentSum = paymentSum;
        this.contractRisk = contractRisk;
    }

    protected Payment(){}

    @Column(name="date", nullable=false)
    public  Date getDate() {
        return date;
    }

    public void setDate( Date date) {
        this.date = date;
    }

    @Column(name="payment_sum", nullable=false)
    public float getPaymentSum() {
        return paymentSum;
    }

    public void setPaymentSum(float paymentSum) {
        this.paymentSum = paymentSum;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="contract_risk_id", nullable=false)
    public ContractRisk getContractRisk() {
        return contractRisk;
    }

    public void setContractRisk(ContractRisk contractRisk) {
        this.contractRisk = contractRisk;
    }


}
