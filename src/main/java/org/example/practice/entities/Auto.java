package org.example.practice.entities;

import jakarta.persistence.*;

@Entity
@Table(name="autos")
public class Auto  extends BaseEntity{
    private String number;
    private String brand;
    private String model;
    private float price;

    private Client client;
    private Contract[] contracts;

    public Auto(String number, String brand, String model, float price, Client client) {
        this.number = number;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.client = client;
    }


    @Column(nullable=false, unique = true)
    public String getNumber() {
        return number;
    }

    @Column(nullable=false)
    public String getBrand() {
        return brand;
    }

    @Column(nullable=false)
    public String getModel() {
        return model;
    }

    @Column(nullable=false)
    public float getPrice() {
        return price;
    }

    @ManyToOne
    @JoinColumn(name="client_id", nullable=false)
    public Client getClient() {
        return client;
    }

    @OneToMany(mappedBy="autos")
    public Contract[] getContracts() {
        return contracts;
    }
}
