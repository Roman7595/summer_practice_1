package org.example.practice.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="contract_risks")
public class ContractRisk extends BaseEntity{
    private Contract contract;
    private Risk risk;

    private Set<Payment> payments;

    public ContractRisk(Contract contract, Risk risk) {
        this.contract = contract;
        this.risk = risk;
    }

    @ManyToOne
    @JoinColumn(name="contract_id", nullable=false)
    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
    @ManyToOne
    @JoinColumn(name="risk_id", nullable=false)
    public Risk getRisk() {
        return risk;
    }

    public void setRisk(Risk risk) {
        this.risk = risk;
    }
    @OneToMany(mappedBy="contractRisk")
    public Set<Payment> getPayments() {
        return payments;
    }

    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }

}
