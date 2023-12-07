package com.emr.emrlite.repository;

import com.emr.emrlite.model.LookUpModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LookUpRepository extends JpaRepository<LookUpModel,Long> {
    @Query("SELECT u FROM LookUpModel u WHERE u.lookuptype IN :lookuptype")
    List<LookUpModel> getLookUpData(List<String> lookuptype);
}
