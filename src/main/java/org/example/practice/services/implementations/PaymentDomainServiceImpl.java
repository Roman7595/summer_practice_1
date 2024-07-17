package org.example.practice.services.implementations;

import org.example.practice.DTO.toAdd.PaymentToAddDTO;
import org.example.practice.exceptions.InvalidPaymentDateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.example.practice.entities.Contract;
import org.example.practice.entities.ContractRisk;
import org.example.practice.entities.Payment;
import org.example.practice.entities.Risk;
import org.example.practice.repositories.interfaces.*;
import org.example.practice.services.interfaces.PaymentDomainService;

import java.util.Optional;
import java.util.Set;

@Service
public class AddPaymentDomainServiceImpl implements PaymentDomainService {
    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private RiskRepository riskRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ContractRiskRepository contractRiskRepository;

    @Override
    public int addPayment(PaymentToAddDTO paymentToAddDTO) throws InvalidPaymentDateException {
        Optional<Contract> contract = contractRepository.findById(paymentToAddDTO.contract_id);
        Optional<Risk> risk = riskRepository.findById(paymentToAddDTO.risk_id);

        if(contract.isEmpty()){
            System.out.println("No contract");
            return -1;
        }

        if(risk.isEmpty()){
            System.out.println("No risk");
            return -1;
        }

        ContractRisk contractRisk = contractRiskRepository.getWhereContractAndRisk(contract.get(), risk.get());

        if(contractRisk == null){
            System.out.println("No contractRisk");
            return -1;
        }

        if (paymentToAddDTO.payment_sum<=0){
            System.out.println("Too small sum");
            return -1;
        }

        Set<Payment> otherPayments = paymentRepository.getWhereContract(contract.get());
        float sumOfPayments = 0;
        for (Payment payment:otherPayments) {
            sumOfPayments += payment.getPaymentSum();
        }

        float maxPaymentSum = contract.get().getLiabilityLimit() - sumOfPayments;
        if (paymentToAddDTO.payment_sum > maxPaymentSum){
            System.out.println("Sum must be less than " + maxPaymentSum);
            return -1;
        }

        if(!(contract.get().getStartTime().before(paymentToAddDTO.date)) || !(paymentToAddDTO.date.before(contract.get().getEndTime()))){
            throw new InvalidPaymentDateException();
        }

        Payment payment = new Payment(paymentToAddDTO.date, paymentToAddDTO.payment_sum, contractRisk);
        paymentRepository.save(payment);
        return payment;
    }
}
