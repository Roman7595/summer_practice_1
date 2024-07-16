package org.example.practice.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name="risks")
public class Risk extends BaseEntity{
    private String name;
    private float defaultRisk;
    private Set<ContractRisk> contractRisks;

    public Risk(String name, float defaultRisk) {
        this.name = name;
        this.defaultRisk = defaultRisk;
    }

    protected Risk(){}

    @Column(name="name", nullable=false, unique=true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="default_risk", nullable=false)
    public float getDefaultRisk() {
        return defaultRisk;
    }

    public void setDefaultRisk(float defaultRisk) {
        this.defaultRisk = defaultRisk;
    }

    @OneToMany(mappedBy="risk")
    public Set<ContractRisk> getContractRisks() {
        return contractRisks;
    }

    public void setContractRisks(Set<ContractRisk> contractRisks) {
        this.contractRisks = contractRisks;
    }
}
