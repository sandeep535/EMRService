package com.emr.emrlite.repository;


import com.emr.emrlite.model.IntistiutionsMasterModel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InstitutionUnitRepository extends JpaRepository<IntistiutionsMasterModel, Long> {
    List<IntistiutionsMasterModel> findByParent_Id(Long parentId);
    List<IntistiutionsMasterModel> findByParentIsNull();  // for root nodes
}