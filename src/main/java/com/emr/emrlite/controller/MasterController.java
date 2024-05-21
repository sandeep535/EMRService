package com.emr.emrlite.controller;


import com.emr.emrlite.dto.AllergiesListPaginationDTO;
import com.emr.emrlite.model.AllergiesMasterModel;
import com.emr.emrlite.model.DrugsMasterModel;
import com.emr.emrlite.service.CommonService;
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
}
