package com.emr.emrlite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emr.emrlite.model.BillPayment;

public interface BillPaymentRepository extends JpaRepository<BillPayment, Long> {

	List<BillPayment> findByBill_BillId(Long billId);

}
