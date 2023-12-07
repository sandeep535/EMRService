package com.emr.emrlite.repository;

import com.emr.emrlite.model.VisitDetailsModel;
import com.emr.emrlite.model.VisitServicesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitDetailsRepository  extends JpaRepository<VisitDetailsModel,Long> {

}
