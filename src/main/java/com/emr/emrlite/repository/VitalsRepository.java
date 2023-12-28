package com.emr.emrlite.repository;

import com.emr.emrlite.model.EmployeeModel;
import com.emr.emrlite.model.VitalsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VitalsRepository extends JpaRepository<VitalsModel,Long> {
    @Query("SELECT u FROM VitalsModel u WHERE u.visitid = :visitid")
    VitalsModel getVitals(Long visitid);
}
