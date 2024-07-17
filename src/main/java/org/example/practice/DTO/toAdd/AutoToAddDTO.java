package org.example.practice.DTO.toAdd;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class AutoToAddDTO {
    @NotNull(message = "number is missing")
    @NotEmpty(message = "number is missing")
    public String number;
    @NotNull(message = "brand is missing")
    @NotEmpty(message = "brand is missing")
    public String brand;
    @NotNull(message = "model is missing")
    @NotEmpty(message = "model is missing")
    public String model;
    @NotNull(message = "price is missing")
    public float price;
    @NotNull(message = "client id is missing")
    public int clientId;

    public AutoToAddDTO(String number, String brand, String model, float price, int clientId) {
        this.number = number;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.clientId = clientId;
    }
}
