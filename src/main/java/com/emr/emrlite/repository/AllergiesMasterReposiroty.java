package com.emr.emrlite.repository;

import com.emr.emrlite.dto.AllergiesListPaginationDTO;
import com.emr.emrlite.dto.AllergiesRequestDTO;
import com.emr.emrlite.model.AllergiesMasterModel;
import org.springframework.data.domain.Pageable;




public interface AllergiesMasterReposiroty {

	AllergiesListPaginationDTO findAllAllergies(AllergiesMasterModel allergiesMasterModel,Pageable page);

    public AllergiesMasterModel saveAllergyMaster(AllergiesMasterModel allergiesMasterModel);
    
    AllergiesRequestDTO findAllergiesfilter(AllergiesRequestDTO allergiesModel,Pageable page);

	

	
}
