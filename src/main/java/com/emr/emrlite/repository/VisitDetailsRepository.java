package com.emr.emrlite.repository;

import com.emr.emrlite.model.EmployeeModel;
import com.emr.emrlite.model.VisitDetailsModel;
import com.emr.emrlite.model.VisitServicesModel;
import lombok.Data;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface VisitDetailsRepository  extends JpaRepository<VisitDetailsModel,Long> {
    @Query("SELECT u FROM VisitDetailsModel u WHERE u.visitdate BETWEEN :fromdate and :todate order by u.visitdate desc")
    List<VisitDetailsModel> getVisitDeatils(Date fromdate, Date todate, Pageable pageRequest);

    @Modifying
    @Query("UPDATE VisitDetailsModel u SET u.status = :visitstatusid WHERE u.visitid = :visitid")
    Integer updateVisitStatus(Long visitid,Integer visitstatusid);

    @Query("SELECT count(*) FROM VisitDetailsModel u WHERE u.visitdate BETWEEN :fromdate and :todate")
    Long getCountBasedOnVisitDate(Date fromdate, Date todate);
    Long countVisitDetailsModelByVisitdateGreaterThanAndVisitdateLessThan(Date fromDate,Date toDate);
}
