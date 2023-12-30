package com.emr.emrlite.repository;

import com.emr.emrlite.model.LookUpModel;
import com.emr.emrlite.model.MasterDataModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MasterDataRepository extends JpaRepository<MasterDataModel,Long> {
    List<MasterDataModel> findMasterDataModelByMastercode(String code);
}
