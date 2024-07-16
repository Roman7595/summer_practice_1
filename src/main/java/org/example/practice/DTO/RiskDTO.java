package org.example.practice.DTO;

public class RiskDTO {
    public int id;
    public String name;
    public float defaultRisk;

    public RiskDTO(int id, String name, float defaultRisk) {
        this.id = id;
        this.name = name;
        this.defaultRisk = defaultRisk;
    }
}
