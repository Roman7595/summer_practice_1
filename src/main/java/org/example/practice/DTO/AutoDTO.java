package org.example.practice.DTO;

public class AutoDTO {
    public int id;
    public String number;
    public String brand;
    public String model;
    public float price;
    public int clientId;

    public AutoDTO(int id, String number, String brand, String model, float price, int clientId) {
        this.id = id;
        this.number = number;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.clientId = clientId;
    }
}
