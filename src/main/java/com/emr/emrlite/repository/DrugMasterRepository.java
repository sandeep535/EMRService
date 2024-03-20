package com.emr.emrlite.repository;

import com.emr.emrlite.model.AllergiesModel;
import com.emr.emrlite.model.DrugsMasterModel;
import com.emr.emrlite.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DrugMasterRepository extends JpaRepository<DrugsMasterModel,Long> {
    @Query("SELECT u FROM DrugsMasterModel u WHERE u.drugname like %:drugname%")
    List<DrugsMasterModel> getDrugMasterData(String drugname);

    DrugsMasterModel findDrugsMasterModelByDrugname(String drugname);
    DrugsMasterModel findDrugsMasterModelByDrugcode(String drugcode);
}
