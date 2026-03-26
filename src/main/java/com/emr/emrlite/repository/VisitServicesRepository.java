package com.emr.emrlite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.emr.emrlite.model.VisitServicesModel;

public interface VisitServicesRepository extends JpaRepository<VisitServicesModel, Long> {

	public List<VisitServicesModel> findVisitServicesByVisitId(Long visitid);
	
	@Modifying
	@Query("UPDATE VisitServicesModel u SET u.billId = :billId WHERE u.visitid = :visitid and u.billId is null")
	Integer updateVisitStatus(Long billId, Long visitid);

	@Query("SELECT SUM(v.servicetotalamount) FROM VisitServicesModel v WHERE v.visitid = :visitid AND v.billId IS NULL")
	Double sumServiceAmountByVisitId(@Param("visitid") Long visitid);

}
