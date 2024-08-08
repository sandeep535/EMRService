package com.emr.emrlite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emr.emrlite.model.LabOrderModel;
import com.emr.emrlite.model.VitalsModel;



public interface LabOrderRepository extends JpaRepository<LabOrderModel,Long> { 
	List<LabOrderModel> findByVisitidAndStatus(Long visitid, Integer status);
    List<LabOrderModel> findAllByClientid(Long clientid);
}
