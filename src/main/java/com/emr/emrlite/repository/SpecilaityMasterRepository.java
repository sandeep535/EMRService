package com.emr.emrlite.repository;

import com.emr.emrlite.model.ServiceMasterModel;
import com.emr.emrlite.model.SpecilaityMasterModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpecilaityMasterRepository extends JpaRepository<SpecilaityMasterModel,Long> {
    @Query("SELECT u FROM SpecilaityMasterModel u WHERE u.status = 1")
    List<SpecilaityMasterModel> getSpecilaityMasterData();
}
