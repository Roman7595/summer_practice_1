package org.example.practice.services.implementations;

import org.example.practice.DTO.PaymentDTO;
import org.example.practice.DTO.toAdd.PaymentToAddDTO;
import org.example.practice.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.example.practice.entities.Contract;
import org.example.practice.entities.ContractRisk;
import org.example.practice.entities.Payment;
import org.example.practice.entities.Risk;
import org.example.practice.repositories.interfaces.*;
import org.example.practice.services.interfaces.PaymentDomainService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PaymentDomainServiceImpl implements PaymentDomainService {
    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private RiskRepository riskRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ContractRiskRepository contractRiskRepository;

    @Override
    public PaymentDTO addPayment(PaymentToAddDTO paymentToAddDTO) throws InvalidPaymentDateException, ContractNotFoundException{
        Optional<Contract> contract = contractRepository.findById(paymentToAddDTO.contractId);
        Optional<Risk> risk = riskRepository.getById(paymentToAddDTO.riskId);

        if(contract.isEmpty()){
            throw new ContractNotFoundException();
        }

        if(risk.isEmpty()){
            throw new RiskNotFoundException();
        }

        ContractRisk contractRisk = contractRiskRepository.getWhereContractAndRisk(contract.get(), risk.get());

        if(contractRisk == null){
            throw new ContractRiskNotFoundException();
        }

        if (paymentToAddDTO.paymentSum <= 0){
           throw new InvalidPaymentSumException("Payment sum must be greater than 0");
        }

        Set<Payment> otherPayments = paymentRepository.getWhereContract(contract.get());
        float sumOfPayments = 0;
        for (Payment payment:otherPayments) {
            sumOfPayments += payment.getPaymentSum();
        }

        float maxPaymentSum = contract.get().getLiabilityLimit() - sumOfPayments;
        if (paymentToAddDTO.paymentSum > maxPaymentSum){
            throw new InvalidPaymentSumException("Sum of all payments for Contract must be less or equal to liability limit");
        }

        if(!(contract.get().getStartTime().before(paymentToAddDTO.date)) || !(paymentToAddDTO.date.before(contract.get().getEndTime()))){
            throw new InvalidPaymentDateException();
        }

        Payment payment = new Payment(paymentToAddDTO.date, paymentToAddDTO.paymentSum, contractRisk);
        paymentRepository.save(payment);

        return new PaymentDTO(payment.getId(), payment.getContractRisk().getContract().getId(), payment.getContractRisk().getRisk().getId(), payment.getDate(), payment.getPaymentSum());
    }
    @Override
    public List<PaymentDTO> getAll(){
        List<Payment> payments = paymentRepository.getAll();
        List<PaymentDTO> paymentDTOs = new ArrayList<>();
        for (Payment payment:payments) {
            paymentDTOs.add(new PaymentDTO(payment.getId(),payment.getContractRisk().getContract().getId(),payment.getContractRisk().getRisk().getId(),payment.getDate(),payment.getPaymentSum()));
        }
        return paymentDTOs;
    }
    public PaymentDTO getById(int id){
        Optional<Payment> payment = paymentRepository.getById(id);
        if(payment.isEmpty()){
            throw new PaymentNotFoundException();
        }
        return new PaymentDTO(payment.get().getId(),payment.get().getContractRisk().getContract().getId(),payment.get().getContractRisk().getRisk().getId(),payment.get().getDate(),payment.get().getPaymentSum());

    }
}
