package org.example.practice.DTO.toAdd;

import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;

public class ContractToAddDTO {
    @NotNull(message = "start time is missing")
    public Date startTime;

    @NotNull(message = "end time is missing")
    public  Date endTime;

    @NotNull(message = "liability limit is missing")
    public float liabilityLimit;
    @NotNull(message = "auto id is missing")
    public int autoId;
    @NotNull(message = "risk ids are missing")
    public List<Integer> riskIds;
    public ContractToAddDTO(Date startTime,  Date endTime, float liabilityLimit, int autoId, List<Integer> riskIds) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.liabilityLimit = liabilityLimit;
        this.autoId = autoId;
        this.riskIds = riskIds;
    }
}
