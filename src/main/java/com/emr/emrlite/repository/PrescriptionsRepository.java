package com.emr.emrlite.repository;

import com.emr.emrlite.dto.PrescriptionsDTO;
import com.emr.emrlite.model.PrescriptionsModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrescriptionsRepository extends JpaRepository<PrescriptionsModel,Long> {
    List<PrescriptionsModel> findByVisitid(Long visitid);
    List<PrescriptionsModel> findByClientid(Long clientid);
}
