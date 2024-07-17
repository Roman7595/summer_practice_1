package org.example.practice.DTO;

import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;

public class ContractDTO {
    public int id;
    public Date startTime;
    public Date endTime;
    public float insurancePremium;
    public float liabilityLimit;
    public int autoId;
    public ContractDTO(int id, Date startTime, Date endTime, float insurancePremium, float liabilityLimit, int autoId) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.insurancePremium = insurancePremium;
        this.liabilityLimit = liabilityLimit;
        this.autoId = autoId;
    }
}
