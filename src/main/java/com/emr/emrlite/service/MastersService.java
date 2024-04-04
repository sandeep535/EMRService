package com.emr.emrlite.service;

import com.emr.emrlite.model.AllergiesMasterModel;
import com.emr.emrlite.model.DrugsMasterModel;
import com.emr.emrlite.repository.AllergiesMasterReposiroty;
import com.emr.emrlite.repository.DrugMasterRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MastersService {
    @Autowired
    AllergiesMasterReposiroty allergiesMasterReposiroty;

    @Transactional
    public AllergiesMasterModel saveAllergiesMatser(AllergiesMasterModel allergiesMasterModel){
        //allergiesMasterReposiroty.save(allergiesMasterModel);
       // allergiesMasterReposiroty.findAllAllergies().
        AllergiesMasterModel allergiesMasterModel2 = allergiesMasterReposiroty.saveAllergyMaster(allergiesMasterModel);
        AllergiesMasterModel allergiesMasterModel1 = new AllergiesMasterModel();
        allergiesMasterModel1.setAllergyid(allergiesMasterModel2.getAllergyid());
        return allergiesMasterModel1;
    }

    @Transactional
    public List<AllergiesMasterModel> getAllergiesMatser(AllergiesMasterModel allergiesMasterModel){
        List<AllergiesMasterModel> allergiesMasterModelsList = new ArrayList<>();
        allergiesMasterModelsList = allergiesMasterReposiroty.findAllAllergies(allergiesMasterModel);
        return allergiesMasterModelsList;
    }
}
