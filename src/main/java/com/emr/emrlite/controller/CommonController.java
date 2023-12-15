package com.emr.emrlite.controller;


import com.emr.emrlite.dto.*;
import com.emr.emrlite.service.CommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
@RequestMapping("/api/common")
@RequiredArgsConstructor
public class CommonController {

    private final CommonService commonService;
    @GetMapping("/lookupdata/{lookuptype}")
    public HashMap<String, List<LookUpDTO>> getClientDataBasedonmobilenumber(@PathVariable("lookuptype") List<String> lookuptype) {
        HashMap<String, List<LookUpDTO>> result =commonService.getLookupData(lookuptype);
        return result;
    }

    @GetMapping("/getEmployeesBasedOnName/{employeeName}")
    public List<EmployeeDTO> getEmployeesBasedOnName(@PathVariable("employeeName") String employeeName) {
        List<EmployeeDTO> employeeDetails =  commonService.getEmployeesBasedOnName(employeeName);
        return employeeDetails;
    }

    @GetMapping("/getServiceMasterData/{serviceName}")
    public List<ServiceMasterDTO> getServiceMasterData(@PathVariable("serviceName") String serviceName) {
        List<ServiceMasterDTO> serviceMasterDetails =  commonService.getServiceMasterData(serviceName);
        return serviceMasterDetails;
    }

    @GetMapping("/getSpecilaityMaster")
    public List<SpecilaityMasterDTO> getSpecilaityMaster() {
        List<SpecilaityMasterDTO> specilaityMasterDetails =  commonService.getSpecilaityMasterDetails();
        return specilaityMasterDetails;
    }

    @GetMapping("/getCountries")
    public List<CountriesDTO> getCountries() {
        List<CountriesDTO> countriesDTODetails =  commonService.getCountries();
        return countriesDTODetails;
    }

    @GetMapping("/getStates/{countryId}")
    public List<StateDTO> getStates(@PathVariable("countryId") Long countryId) {
        List<StateDTO> StateDTOs =  commonService.getStates(countryId);
        return StateDTOs;
    }

    @GetMapping("/getCities/{stateId}")
    public List<CityDTO> getCity(@PathVariable("stateId") Long stateId) {
        List<CityDTO> CityDTOs =  commonService.getCities(stateId);
        return CityDTOs;
    }
}