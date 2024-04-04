package com.emr.emrlite.repository;

import com.emr.emrlite.model.AllergiesMasterModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


public interface AllergiesMasterReposiroty {

    List<AllergiesMasterModel> findAllAllergies(AllergiesMasterModel allergiesMasterModel);

    public AllergiesMasterModel saveAllergyMaster(AllergiesMasterModel allergiesMasterModel);
}
