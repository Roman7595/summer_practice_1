package org.example.practice.services.interfaces;

import org.example.practice.exceptions.AutoNotFoundException;
import org.example.practice.exceptions.ClientNotFoundException;

import java.util.List;

public interface InsurancePremiumCounterDomainService {
    public float countInsurancePremium(int auto_id, List<Integer> risk_ids) throws ClientNotFoundException, AutoNotFoundException;
}
