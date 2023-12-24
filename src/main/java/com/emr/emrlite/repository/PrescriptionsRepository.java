package com.emr.emrlite.repository;

import com.emr.emrlite.model.PrescriptionsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionsRepository extends JpaRepository<PrescriptionsModel,Long> {

}
