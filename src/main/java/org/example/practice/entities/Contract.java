package org.example.practice.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name="contracts")
public class Contract extends BaseEntity{
    private  Date startTime;
    private  Date endTime;
    private float insurancePremium;
    private float liabilityLimit;
    private Auto auto;
    private Set<ContractRisk> contractRisks;
    public Contract( Date startTime,  Date endTime, float insurancePremium, float liabilityLimit, Auto auto) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.insurancePremium = insurancePremium;
        this.liabilityLimit = liabilityLimit;
        this.auto = auto;
    }
    protected Contract(){}
    @Column(name="start_time", nullable=false)
    public  Date getStartTime() {
        return startTime;
    }

    public void setStartTime( Date startTime) {
        this.startTime = startTime;
    }

    @Column(name="end_time", nullable=false)
    public  Date getEndTime() {
        return endTime;
    }

    public void setEndTime( Date endTime) {
        this.endTime = endTime;
    }

    @Column(name="insurance_premium", nullable=false)
    public float getInsurancePremium() {
        return insurancePremium;
    }

    public void setInsurancePremium(float insurancePremium) {
        this.insurancePremium = insurancePremium;
    }

    @Column(name="liability_limit", nullable=false)
    public float getLiabilityLimit() {
        return liabilityLimit;
    }

    public void setLiabilityLimit(float liabilityLimit) {
        this.liabilityLimit = liabilityLimit;
    }

    @ManyToOne
    @JoinColumn(name="auto_id", nullable=false)
    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    @OneToMany(mappedBy="contract", fetch = FetchType.LAZY)
    public Set<ContractRisk> getContractRisks() {
        return contractRisks;
    }

    public void setContractRisks(Set<ContractRisk> contractRisks) {
        this.contractRisks = contractRisks;
    }


}
