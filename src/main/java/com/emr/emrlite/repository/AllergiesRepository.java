package com.emr.emrlite.repository;

import com.emr.emrlite.model.AllergiesModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AllergiesRepository extends JpaRepository<AllergiesModel,Long> {
    List<AllergiesModel> findAllergiesModelByVisitid(Long visitid);
    List<AllergiesModel> findAllergiesModelByClientid(Long clientid);
}
