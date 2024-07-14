package org.example.practice.DTO;

import org.example.practice.entities.Client;
import org.example.practice.entities.Risk;

import java.util.List;

public class AccurateClientDTO {
    public List<Risk> risks;
    public Client[] bestClients;
    public int[] paymentCounts;

    public AccurateClientDTO(List<Risk> risks, Client[] bestClients, int[] paymentCounts) {
        this.risks = risks;
        this.bestClients = bestClients;
        this.paymentCounts = paymentCounts;
    }
}
