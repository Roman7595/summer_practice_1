package org.example.practice.services.implementations;

import org.example.practice.DTO.ContractDTO;
import org.example.practice.DTO.toAdd.ContractToAddDTO;
import org.example.practice.entities.*;
import org.example.practice.exceptions.*;
import org.example.practice.repositories.interfaces.*;
import org.example.practice.services.interfaces.ContractDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ContractDomainServiceImpl implements ContractDomainService {
    @Autowired
    private ContractRepository contractRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private RiskRepository riskRepository;
    @Autowired
    private ContractRiskRepository contractRiskRepository;
    @Autowired
    private AutoRepository autoRepository;

    @Override
    public int addContract(ContractToAddDTO contractToAdd) throws ClientNotFoundException, AutoNotFoundException, InvalidContractTimePeriodException, InvalidLiabilityLimitException, RiskNotFoundException, TooExpansiveException{
        if (contractToAdd.startTime.after(contractToAdd.endTime) || contractToAdd.startTime.equals(contractToAdd.endTime)){
            throw new InvalidContractTimePeriodException();
        }

        Optional<Auto> auto = autoRepository.findById(contractToAdd.autoId);
        if (auto.isEmpty()){
            throw new AutoNotFoundException();
        }

        if (contractToAdd.liabilityLimit > auto.get().getPrice()){
            throw new InvalidLiabilityLimitException();
        }

        Client client = clientRepository.getWhereAutos(auto.get());
        if (client == null){
            throw new ClientNotFoundException();
        }

        Set<Contract> allContracts = contractRepository.getWhereClient(client);
        for (Contract con:allContracts) {
            if ((!(contractToAdd.startTime.after(con.getStartTime())) && con.getStartTime().before(contractToAdd.endTime)) ||
            (contractToAdd.startTime.before(con.getEndTime()) && !(con.getEndTime().after(contractToAdd.endTime)))){
                throw new ContractPeriodOfTimeCollisionException();
            }
        }

        Set<Risk> allRisks = riskRepository.getAllByIds(contractToAdd.riskIds);
        if (allRisks.size() == 0){
            throw new RiskNotFoundException();
        }

        float insurancePremium = this.countInsurancePremium(contractToAdd.liabilityLimit, allContracts, allRisks);
        Contract newContract = new Contract(contractToAdd.startTime, contractToAdd.endTime, insurancePremium, contractToAdd.liabilityLimit, auto.get());
        contractRepository.save(newContract);
        for (Risk risk:allRisks) {
            ContractRisk contractRisk = new ContractRisk(newContract, risk);
            contractRiskRepository.save(contractRisk);
        }
        return newContract.getId();
    }

    private float countInsurancePremium(float liabilityLimit, Set<Contract> allContracts, Set<Risk> allRisks) throws TooExpansiveException {

            float riskCoef = 0;
            for (Risk risk:
                    allRisks) {
                Set<ContractRisk> contractRisks = contractRiskRepository.getWhereContractAndRisk(allContracts, risk);
                float specialCoef;

                if (contractRisks.size() == 0){
                    specialCoef = 1;
                }else {
                    int call = contractRisks.size();
                    float cpay = 0;
                    for (ContractRisk cr : contractRisks) {
                        cpay += cr.getPayments().size();
                    }
                    specialCoef = (cpay/call);
                }

                riskCoef += ((specialCoef + 1) * risk.getDefaultRisk());
            }
            if (riskCoef >= 1){
                throw new TooExpansiveException();
            }

            float insurancePremium = riskCoef * liabilityLimit;
            return insurancePremium;

    }
    @Override
    public List<ContractDTO> getAll(){
        List<Contract> contracts = contractRepository.getAll();
        List<ContractDTO> contractDTOs = new ArrayList<>();
        for (Contract contract:contracts) {
            contractDTOs.add(new ContractDTO(contract.getId(),contract.getStartTime(),contract.getEndTime(),contract.getInsurancePremium(), contract.getLiabilityLimit(), contract.getAuto().getId()));
        }
        return contractDTOs;
    }
    @Override
    public ContractDTO getById(int id){
        Optional<Contract> contract = contractRepository.findById(id);
        if(contract.isEmpty()){
            throw new ContractNotFoundException();
        }

        return new ContractDTO(contract.get().getId(),contract.get().getStartTime(),contract.get().getEndTime(),contract.get().getInsurancePremium(), contract.get().getLiabilityLimit(), contract.get().getAuto().getId());
    }

}
