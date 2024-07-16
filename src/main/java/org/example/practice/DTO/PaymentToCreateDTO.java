package org.example.practice.DTO;

import java.util.Date;

public class PaymentToCreateDTO {
    public int contract_id;
    public int risk_id;
    public Date date;
    public float payment_sum;

    public PaymentToCreateDTO(int contract_id, int risk_id, Date date, float payment_sum) {
        this.contract_id = contract_id;
        this.risk_id = risk_id;
        this.date = date;
        this.payment_sum = payment_sum;
    }
}
