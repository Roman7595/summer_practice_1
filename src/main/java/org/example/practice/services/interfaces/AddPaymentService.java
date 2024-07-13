package org.example.practice.services.interfaces;

import java.util.Date;

public interface AddPaymentService {
    public int addPayment(int contract_id, int risk_id, Date date, float payment_sum);
}
