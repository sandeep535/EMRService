package com.emr.emrlite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.emr.emrlite.dto.VisitDetailsDTO;
import com.emr.emrlite.model.BillPayment;
import com.emr.emrlite.model.VisitDetailsModel;

public interface BillPaymentRepository extends JpaRepository<BillPayment, Long> {

	List<BillPayment> findByBill_BillId(Long billId);
	@Query("SELECT DISTINCT vd FROM VisitDetailsModel vd " +
		       "JOIN FETCH vd.services vs " +
		       "WHERE vd.clientid.id = :clientId " +
		       "AND ( (:status = 'Pending' AND vs.billId IS NULL) " +
		       "   OR (:status <> 'Pending' AND vs.billId IS NOT NULL) )")
	List<VisitDetailsModel> findPendingBillsByClientId(Long clientId,String status);

}
