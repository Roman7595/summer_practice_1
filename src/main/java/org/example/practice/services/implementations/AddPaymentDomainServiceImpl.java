package org.example.practice.services.implementations;

import org.example.practice.DTO.PaymentToCreateDTO;
import org.example.practice.exceptions.InvalidPaymentDateException;
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

import java.util.Optional;
import java.util.Set;

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
    public int addPayment(PaymentToCreateDTO paymentToCreateDTO) throws InvalidPaymentDateException {
        Optional<Contract> contract = contractRepository.findById(paymentToCreateDTO.contract_id);
        Optional<Risk> risk = riskRepository.findById(paymentToCreateDTO.risk_id);

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

        if (paymentToCreateDTO.payment_sum<=0){
            System.out.println("Too small sum");
            return -1;
        }

        Set<Payment> otherPayments = paymentRepository.getWhereContract(contract.get());
        float sumOfPayments = 0;
        for (Payment payment:otherPayments) {
            sumOfPayments += payment.getPaymentSum();
        }

        float maxPaymentSum = contract.get().getLiabilityLimit() - sumOfPayments;
        if (paymentToCreateDTO.payment_sum > maxPaymentSum){
            System.out.println("Sum must be less than " + maxPaymentSum);
            return -1;
        }

        if(!(contract.get().getStartTime().before(paymentToCreateDTO.date)) || !(paymentToCreateDTO.date.before(contract.get().getEndTime()))){
            throw new InvalidPaymentDateException();
        }

        Payment payment = new Payment(paymentToCreateDTO.date, paymentToCreateDTO.payment_sum, contractRisk);
        paymentRepository.save(payment);
        return payment.getId();
    }
}
