package com.emr.emrlite.repository;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.emr.emrlite.model.VisitDetailsModel;

public interface VisitDetailsRepository  extends JpaRepository<VisitDetailsModel,Long> {
    @Query(value ="SELECT u FROM VisitDetailsModel u WHERE u.status =:status and u.visitdate BETWEEN :fromdate and :todate order by u.visitdate desc",
    		countQuery = "SELECT u FROM VisitDetailsModel u WHERE u.status =:status and u.visitdate BETWEEN :fromdate and :todate")
    Page<VisitDetailsModel> getVisitDeatils(Date fromdate, Date todate,Integer status, Pageable pageRequest);

    @Modifying
    @Query("UPDATE VisitDetailsModel u SET u.status = :visitstatusid WHERE u.visitid = :visitid")
    Integer updateVisitStatus(Long visitid,Integer visitstatusid);

    @Query("SELECT count(*) FROM VisitDetailsModel u WHERE u.visitdate BETWEEN :fromdate and :todate")
    Long getCountBasedOnVisitDate(Date fromdate, Date todate);
    Long countVisitDetailsModelByVisitdateGreaterThanAndVisitdateLessThan(Date fromDate,Date toDate);
}
