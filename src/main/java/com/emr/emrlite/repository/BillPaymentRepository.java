package com.emr.emrlite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emr.emrlite.model.BillPayment;

public interface BillPaymentRepository extends JpaRepository<BillPayment, Long> {

}
