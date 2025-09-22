package com.emr.emrlite.controller;


import com.emr.emrlite.dto.AllergiesListPaginationDTO;
import com.emr.emrlite.dto.DiagnosisMasterDTO;
import com.emr.emrlite.dto.DiagnosisMasterPaginationDTO;
import com.emr.emrlite.dto.InstitutionUnitDTO;
import com.emr.emrlite.dto.LabMasterPaginationDTO;
import com.emr.emrlite.model.AllergiesFavouriteModel;
import com.emr.emrlite.model.AllergiesMasterModel;
import com.emr.emrlite.model.DiagnosisMasterModel;
import com.emr.emrlite.model.DrugsMasterModel;
import com.emr.emrlite.model.IntistiutionsMasterModel;
import com.emr.emrlite.model.LabMasterModel;
import com.emr.emrlite.service.CommonService;
import com.emr.emrlite.service.InstitutionUnitService;
import com.emr.emrlite.service.MastersService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(
        origins = {
                "http://localhost:3000",
        },
        methods = {
                RequestMethod.OPTIONS,
                RequestMethod.GET,
                RequestMethod.PUT,
                RequestMethod.DELETE,
                RequestMethod.POST
        })
@RestController
@RequestMapping("/api/masters")
@RequiredArgsConstructor
public class MasterController {
	@Autowired
    MastersService mastersService;
	
	@Autowired
    InstitutionUnitService service;
    
    @PostMapping(value="/saveAllergiesMatser")
    public AllergiesMasterModel saveAllergiesMatser(@RequestBody AllergiesMasterModel saveAllergiesMatser) {
        AllergiesMasterModel result = mastersService.saveAllergiesMatser(saveAllergiesMatser);
        return result;
    }

    @PostMapping(value="/getAllergiesMatser")
    public AllergiesListPaginationDTO getAllergiesMatser(@RequestBody AllergiesListPaginationDTO allergiesListPaginationDTO) {
    	AllergiesListPaginationDTO result = mastersService.getAllergiesMatser(allergiesListPaginationDTO);
        return result;
    }
    
    
    @PostMapping(value="/saveDiagnosisMatser")
    public DiagnosisMasterModel saveDiagnosisMatser(@RequestBody DiagnosisMasterModel diagnosisMasterDTO) {
    	DiagnosisMasterModel result = mastersService.saveDiagnosisMatser(diagnosisMasterDTO);
        return result;
    }
    
    @PostMapping(value="/getDiagnosisMatser")
    public DiagnosisMasterPaginationDTO getAllergiesMatser(@RequestBody DiagnosisMasterPaginationDTO diagnosisMasterPaginationDTO) {
    	DiagnosisMasterPaginationDTO result = mastersService.getDiagnosisMatser(diagnosisMasterPaginationDTO);
        return result;
    }
    
    @PostMapping(value="/saveLabMatser")
    public LabMasterModel saveLabMatser(@RequestBody LabMasterModel labMasterModel) {
    	LabMasterModel result = mastersService.saveLabMatser(labMasterModel);
        return result;
    }
    
    @PostMapping(value="/getLabMatser")
    public LabMasterPaginationDTO getLabMatser(@RequestBody LabMasterPaginationDTO labMasterPaginationDTO) {
    	LabMasterPaginationDTO result = mastersService.getLabMatser(labMasterPaginationDTO);
        return result;
    }
    
    @PostMapping(value="/saveFavouriteallergies")
    public Boolean saveFavouriteallergies(@RequestBody List<AllergiesFavouriteModel> allergiesFavouriteModel) {
    	Boolean result = mastersService.saveFavouriteallergies(allergiesFavouriteModel);
        return result;
    }
    

    @PostMapping(value="/institution-units")
    public IntistiutionsMasterModel create(@RequestBody InstitutionUnitDTO unit) {
        return service.saveUnit(unit);
    }

    @GetMapping("/institution-units")
    public List<IntistiutionsMasterModel> getAll() {
        return service.getAll();
    }

    @GetMapping("institution-units/{parentId}/children")
    public List<IntistiutionsMasterModel> getChildren(@PathVariable Long parentId) {
        return service.getChildren(parentId);
    }

    @GetMapping("institution-units/children")
    public List<IntistiutionsMasterModel> getChildrenByQuery(@RequestParam(value = "parentId", required = false) Long parentId) {
        return service.getChildren(parentId);
    }
    
    
}
