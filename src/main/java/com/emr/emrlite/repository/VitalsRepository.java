package com.emr.emrlite.repository;

import com.emr.emrlite.model.EmployeeModel;
import com.emr.emrlite.model.VitalsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VitalsRepository extends JpaRepository<VitalsModel,Long> {

}
