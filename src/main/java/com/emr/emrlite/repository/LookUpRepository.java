package com.emr.emrlite.repository;

import com.emr.emrlite.model.CityModel;
import com.emr.emrlite.model.CountriesModel;
import com.emr.emrlite.model.LookUpModel;
import com.emr.emrlite.model.StateModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LookUpRepository extends JpaRepository<LookUpModel,Long> {
    @Query("SELECT u FROM LookUpModel u WHERE u.lookuptype IN :lookuptype")
    List<LookUpModel> getLookUpData(List<String> lookuptype);

    @Query("SELECT u FROM CountriesModel u WHERE u.status =1")
    List<CountriesModel> getCountries();

    @Query("SELECT u FROM StateModel u WHERE u.countryid =:countryId and u.status =1")
    List<StateModel> getStates(Long countryId);

    @Query("SELECT u FROM CityModel u WHERE u.stateid =:stateid and u.status =1")
    List<CityModel> getCities(Long stateid);
}
