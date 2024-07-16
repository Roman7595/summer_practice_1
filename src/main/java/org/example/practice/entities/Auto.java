package org.example.practice.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="autos")
public class Auto extends BaseEntity{
    private String number;
    private String brand;
    private String model;
    private float price;

    private Client client;
    private Set<Contract> contracts;

    public Auto(String number, String brand, String model, float price, Client client) {
        this.number = number;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.client = client;
    }

    protected Auto(){}

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

    @OneToMany(mappedBy="auto")
    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }
}
