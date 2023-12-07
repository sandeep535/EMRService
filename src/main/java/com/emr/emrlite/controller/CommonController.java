package com.emr.emrlite.controller;


import com.emr.emrlite.dto.EmployeeDTO;
import com.emr.emrlite.dto.LookUpDTO;
import com.emr.emrlite.dto.ServiceMasterDTO;
import com.emr.emrlite.dto.SpecilaityMasterDTO;
import com.emr.emrlite.service.CommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

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

    @GetMapping("/getServiceMasterData")
    public List<ServiceMasterDTO> getEmployeesBasedOnName() {
        List<ServiceMasterDTO> serviceMasterDetails =  commonService.getServiceMasterData();
        return serviceMasterDetails;
    }

    @GetMapping("/getSpecilaityMaster")
    public List<SpecilaityMasterDTO> getSpecilaityMaster() {
        List<SpecilaityMasterDTO> specilaityMasterDetails =  commonService.getSpecilaityMasterDetails();
        return specilaityMasterDetails;
    }

}
