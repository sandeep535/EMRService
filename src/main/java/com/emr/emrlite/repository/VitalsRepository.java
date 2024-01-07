package com.emr.emrlite.repository;

import com.emr.emrlite.model.EmployeeModel;
import com.emr.emrlite.model.VitalsModel;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.function.Function;

public interface VitalsRepository extends JpaRepository<VitalsModel,Long> {
    //@Query("SELECT u FROM VitalsModel u WHERE u.visitid = :label")
    //VitalsModel getVitals(Long visitid);

    List<VitalsModel> findByVisitid(Long visitid);
    List<VitalsModel> findAllByClientid(Long clientid);
}
