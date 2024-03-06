package com.emr.emrlite.controller;


import com.emr.emrlite.dto.*;
import com.emr.emrlite.model.RoleTaksActionsModel;
import com.emr.emrlite.model.RolesAndTaskResponseModel;
import com.emr.emrlite.model.TaskActionsModel;
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

    @GetMapping("/getEmployeesAllEmp/{pageNumber}/{pageSize}")
    public List<EmployeeDTO> getEmployeesAllEmp(@PathVariable("pageNumber") Integer pageNumber,@PathVariable("pageSize") Integer pageSize) {
        List<EmployeeDTO> employeeDetails =  commonService.getEmployeesAllEmp(pageNumber,pageSize);
        return employeeDetails;
    }

    @PostMapping("/saveEmployee")
    public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO result = commonService.saveEmployee(employeeDTO);
        return result;
    }

    @PostMapping("/saveServiceMasterData")
    public ServiceMasterDTO saveServiceMasterData(@RequestBody ServiceMasterDTO serviceMasterDTO){
        ServiceMasterDTO result = commonService.saveServiceMasterData(serviceMasterDTO);
        return result;
    }

    @GetMapping("/getServiceMasterData/{serviceName}")
    public List<ServiceMasterDTO> getServiceMasterData(@PathVariable("serviceName") String serviceName) {
        List<ServiceMasterDTO> serviceMasterDetails =  commonService.getServiceMasterData(serviceName);
        return serviceMasterDetails;
    }

    @GetMapping("/getAllServiceMasterData/{pageNumber}/{pageSize}")
    public List<ServiceMasterDTO> getAllServiceMasterData(@PathVariable("pageNumber") Integer pageNumber,@PathVariable("pageSize") Integer pageSize) {
        List<ServiceMasterDTO> serviceMasterDetails =  commonService.getAllServiceMasterData(pageNumber,pageSize);
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

    @GetMapping("/getMasterDataBasedCode/{code}")
    public List<MasterDataDTO> getMasterDataBasedCode(@PathVariable("code") String code) {
        List<MasterDataDTO> masterDataDTO =  commonService.getMasterDataBasedCode(code);
        return masterDataDTO;
    }

    @GetMapping("/getRolesAndTasksMasterData/{code}")
    public List<TaskActionsModel> getRolesAndTasks(@PathVariable("code") String code) {
        List<TaskActionsModel> masterDataDTO =  commonService.getRolesAndTasks(code);
        return masterDataDTO;
    }

    @GetMapping("/getRolesAndTasksTrans/{roleid}")
    public List<RolesAndTaskResponseModel> getRolesAndTasksTransBasedonRoleId(@PathVariable("roleid") Long roleid) {
        List<RolesAndTaskResponseModel> masterDataDTO =  commonService.getRolesAndTasksTransBasedonRoleId(roleid);
        return masterDataDTO;
    }


    @PostMapping("/saveRolesTasks")
    public Boolean saveRolesTasks(@RequestBody List<RoletaksactionsDTO> roletaksactionsDTO){
        Boolean result = commonService.saveRolesTasks(roletaksactionsDTO);
        return result;
    }




}
