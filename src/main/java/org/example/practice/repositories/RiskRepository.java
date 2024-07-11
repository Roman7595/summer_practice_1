package org.example.practice.repositories;

import org.example.practice.entities.Contract;
import org.example.practice.entities.Payment;
import org.example.practice.entities.Risk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RiskRepository  extends JpaRepository<Risk, Integer> {

    @Query(value = "select r from Risk r where r.id in :ids")
    List<Risk> getAllByIds(@Param(value = "ids")Set<Integer> ids);
    @Query(value = "select r from Risk r join r.contractRisks cr")
    List<Risk> getAllOccurences();

    @Query(value = "select r from Risk r join r.contractRisks cr join cr.contract c where c in :contracts")
    List<Risk> getAllOccurencesWhereContract(@Param(value = "contracts")Set<Contract> contracts);

    @Query(value = "select r from Risk r join r.contractRisks cr join cr.payments p where p in :payments")
    List<Risk> getAllOccurencesWherePayment(@Param(value = "payments")Set<Payment> payments);

}
