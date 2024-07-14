package org.example.practice.services.interfaces;

import java.util.List;

public interface InsurancePremiumCounterDomainService {
    public float countInsurancePremium(int auto_id, List<Integer> risk_ids);
}
