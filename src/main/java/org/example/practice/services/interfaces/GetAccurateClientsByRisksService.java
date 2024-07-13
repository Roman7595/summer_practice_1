package org.example.practice.services.interfaces;

import org.example.practice.entities.Client;

import java.util.Set;

public interface GetAccurateClientsByRisksService {
    Set<Client> getAccurateClientsByRisks();
}
