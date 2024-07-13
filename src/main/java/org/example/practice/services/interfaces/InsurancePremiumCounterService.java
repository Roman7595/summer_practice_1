package org.example.practice.services.interfaces;

import java.util.Set;

public interface InsurancePremiumCounterService {
    public float countInsurancePremium(int auto_id, Set<Integer> risk_ids);
}
