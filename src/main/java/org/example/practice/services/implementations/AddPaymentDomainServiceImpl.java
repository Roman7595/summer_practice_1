package org.example.practice.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.example.practice.entities.Contract;
import org.example.practice.entities.ContractRisk;
import org.example.practice.entities.Payment;
import org.example.practice.entities.Risk;
import org.example.practice.repositories.ContractRepository;
import org.example.practice.repositories.ContractRiskRepository;
import org.example.practice.repositories.PaymentRepository;
import org.example.practice.repositories.RiskRepository;
import org.example.practice.services.interfaces.AddPaymentDomainService;

import java.util.Date;

@Service
public class AddPaymentDomainServiceImpl implements AddPaymentDomainService {
    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private RiskRepository riskRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ContractRiskRepository contractRiskRepository;

    @Override
    public int addPayment(int contract_id, int risk_id, Date date, float payment_sum) {
        Contract contract = contractRepository.getReferenceById(contract_id);
        Risk risk = riskRepository.getReferenceById(risk_id);

        ContractRisk contractRisks = contractRiskRepository.getWhereContractAndRisk(contract,risk);

        if(contractRisks==null){
            System.out.println("No contractRisk");
            return 0;
        }

        if (payment_sum<=0){
            System.out.println("Bad sum");
            return 0;
        }

        if((contract.getStartTime().before(date)) || (date.before(contract.getEndTime()))){
            System.out.println("Bad Date");
            return 0;
        }

        Payment payment = new Payment(date, payment_sum, contractRisks);
        paymentRepository.save(payment);
        return payment.getId();
    }
}
