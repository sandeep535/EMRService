package com.emr.emrlite.service;

import com.emr.emrlite.dto.AllergiesListPaginationDTO;
import com.emr.emrlite.dto.DiagnosisMasterDTO;
import com.emr.emrlite.dto.DiagnosisMasterPaginationDTO;
import com.emr.emrlite.model.AllergiesMasterModel;
import com.emr.emrlite.model.DiagnosisMasterModel;
import com.emr.emrlite.model.DrugsMasterModel;
import com.emr.emrlite.repository.AllergiesMasterReposiroty;
import com.emr.emrlite.repository.DiagnosisMasterRepository;
import com.emr.emrlite.repository.DrugMasterRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MastersService {
    @Autowired
    AllergiesMasterReposiroty allergiesMasterReposiroty;
    
    @Autowired
    DiagnosisMasterRepository diagnosisMasterRepository;

    @Transactional
    public AllergiesMasterModel saveAllergiesMatser(AllergiesMasterModel allergiesMasterModel){
        AllergiesMasterModel allergiesMasterModel2 = allergiesMasterReposiroty.saveAllergyMaster(allergiesMasterModel);
        AllergiesMasterModel allergiesMasterModel1 = new AllergiesMasterModel();
        allergiesMasterModel1.setAllergyid(allergiesMasterModel2.getAllergyid());
        return allergiesMasterModel1;
    }

    @Transactional
    public AllergiesListPaginationDTO getAllergiesMatser(AllergiesListPaginationDTO allergiesListPaginationReqDTO){
    	AllergiesListPaginationDTO allergiesListPaginationDTO = new AllergiesListPaginationDTO();
        Pageable paging = PageRequest.of(allergiesListPaginationReqDTO.getPagenumber(), allergiesListPaginationReqDTO.getPagesize());
        allergiesListPaginationDTO = allergiesMasterReposiroty.findAllAllergies(allergiesListPaginationReqDTO.getAllergieslist().get(0),paging);
        return allergiesListPaginationDTO;
    }
    
    @Transactional
    public DiagnosisMasterModel saveDiagnosisMatser(DiagnosisMasterModel diagnosisMasterDTO){
    	diagnosisMasterRepository.saveDiagnosisMaster(diagnosisMasterDTO);
        return diagnosisMasterDTO;
    }
    @Transactional
    public DiagnosisMasterPaginationDTO getDiagnosisMatser(DiagnosisMasterPaginationDTO diagnosisMasterPaginationDTO){
    	
    	DiagnosisMasterPaginationDTO diagnosisMasterPaginationResultDTO = new DiagnosisMasterPaginationDTO();
        
        diagnosisMasterPaginationResultDTO = diagnosisMasterRepository.getDiagnosisMatser(diagnosisMasterPaginationDTO);
        return diagnosisMasterPaginationResultDTO;
    }
    
    
    
}
