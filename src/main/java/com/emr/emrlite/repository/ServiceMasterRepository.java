package com.emr.emrlite.repository;

import com.emr.emrlite.model.RegistrationModel;
import com.emr.emrlite.model.ServiceMasterModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServiceMasterRepository extends JpaRepository<ServiceMasterModel,Long> {
    @Query("SELECT u FROM ServiceMasterModel u WHERE u.active = 1")
    List<ServiceMasterModel> getServiceMasterData();
}
