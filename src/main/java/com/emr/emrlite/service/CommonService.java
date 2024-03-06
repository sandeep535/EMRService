package com.emr.emrlite.service;

import com.emr.emrlite.dto.*;
import com.emr.emrlite.model.*;
import com.emr.emrlite.repository.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommonService {
    private final LookUpRepository lookUpRepositaory;
    private final EmployeeRepository employeeRepository;
    private final ServiceMasterRepository serviceMasterRepository;
    private final SpecilaityMasterRepository specilaityMasterRepository;
    private final MasterDataRepository masterDataRepository;
    private final TaskActionsRepository taskActionsRepository;
    private  final RoleTaksActionsRepository roleTaksActionsRepository;
    private final RolesAndTaskResponseRepository rolesAndTaskResponseRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public HashMap<String, List<LookUpDTO>> getLookupData(List<String> lookuptype) {
        LookUpList mainList = new LookUpList();
        List<LookUpModel> list= lookUpRepositaory.getLookUpData(lookuptype);
        System.out.println("--------->0"+list.size());
        List<LookUpDTO> res = new ArrayList<>();
        HashMap<String, List<LookUpDTO>> hash_map = new HashMap<String, List<LookUpDTO>>();
        list.stream().forEach(item->{
            LookUpDTO lookup = new LookUpDTO();
            lookup.setLookupcode(item.getLookupcode());
            lookup.setLookupid(item.getLookupid());
            lookup.setLookupvalue(item.getLookupvalue());
            lookup.setLookuptype(item.getLookuptype());
            if(hash_map.containsKey(item.getLookuptype())){
                List<LookUpDTO> res1 = hash_map.get(item.getLookuptype());
                res1.add(lookup);
                hash_map.put(item.getLookuptype(),res1);
            }else{
                List<LookUpDTO> res2 = new ArrayList<>();
                res2.add(lookup);
                hash_map.put(item.getLookuptype(),res2);
            }
        });
        return hash_map;
    }

    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO){
        EmployeeModel employeeModel = new EmployeeModel();
        employeeModel.setDesignation(employeeDTO.getDesignation());
        String encoderPassword = passwordEncoder.encode(employeeDTO.getPassword());
        employeeModel.setPassword(encoderPassword);
        employeeModel.setGender(employeeDTO.getGender());
        employeeModel.setFirstname(employeeDTO.getFirstname());
        employeeModel.setLastname(employeeDTO.getLastname());
        employeeModel.setUsername(employeeDTO.getUsername());
        employeeModel.setRole(employeeDTO.getRole());
        employeeModel.setAge(employeeDTO.getAge());
        employeeModel.setDob(employeeDTO.getDob());
        employeeModel.setMail(employeeDTO.getMail());
        employeeModel.setMobilenumber(employeeDTO.getMobilenumber());
        employeeRepository.save(employeeModel);
        EmployeeDTO employeeDTO1= new EmployeeDTO();
        employeeDTO1.setId(employeeModel.getId());
        return  employeeDTO1;
    }

    public List<EmployeeDTO> getEmployeesAllEmp(Integer pageNumber,Integer pageSize){
        //PageRequest pageRequest = PageRequest.of(pageNumber,pageSize);
        Pageable paging = PageRequest.of(pageNumber, pageSize);
        List<EmployeeModel> result = employeeRepository.findAllEmp(paging);
        List<EmployeeDTO> resultDTO = new ArrayList<>();
        result.forEach(emp->{
            EmployeeDTO empDetails = new EmployeeDTO();
            empDetails.setDesignation(emp.getDesignation());
            empDetails.setFirstname(emp.getFirstname());
            empDetails.setLastname(emp.getLastname());
            empDetails.setTitle(emp.getTitle());
            empDetails.setId(emp.getId());
            empDetails.setGender(emp.getGender());
            empDetails.setEmpid(emp.getEmpid());
            empDetails.setAge(emp.getAge());
            empDetails.setMail(emp.getMail());
            empDetails.setDob(emp.getDob());
            empDetails.setRole(emp.getRole());
            resultDTO.add(empDetails);
        });
        return resultDTO;
    }

    public List<EmployeeDTO> getEmployeesBasedOnName(String employeeName){
        List<EmployeeModel> result = employeeRepository.getEmployeesBasedOnName(employeeName);
        List<EmployeeDTO> resultDTO = new ArrayList<>();
        result.forEach(emp->{
            EmployeeDTO empDetails = new EmployeeDTO();
            empDetails.setDesignation(emp.getDesignation());
            empDetails.setFirstname(emp.getFirstname());
            empDetails.setLastname(emp.getLastname());
            empDetails.setTitle(emp.getTitle());
            empDetails.setId(emp.getId());
            empDetails.setGender(emp.getGender());
            empDetails.setEmpid(emp.getEmpid());
            resultDTO.add(empDetails);
        });
        return resultDTO;
    }


    public ServiceMasterDTO saveServiceMasterData(ServiceMasterDTO serviceMasterDTO){
        ServiceMasterModel  serviceMasterModel = new ServiceMasterModel();
        serviceMasterModel.setActive(serviceMasterDTO.getActive());
        serviceMasterModel.setPrice(serviceMasterDTO.getPrice());
        serviceMasterModel.setServicename(serviceMasterDTO.getServicename());
        serviceMasterModel.setServiceid(serviceMasterDTO.getServiceid());
        serviceMasterRepository.save(serviceMasterModel);
        ServiceMasterDTO serviceMasterDTO1 = new ServiceMasterDTO();
        serviceMasterDTO1.setServiceid(serviceMasterModel.getServiceid());
        return serviceMasterDTO1;
    }
    public List<ServiceMasterDTO> getServiceMasterData(String serviceName){
        List<ServiceMasterModel> serviceMasterResult = serviceMasterRepository.getServiceMasterData(serviceName);
        List<ServiceMasterDTO> serviceMasterDTOList = new ArrayList<>();
        serviceMasterResult.forEach(master->{
            ServiceMasterDTO masterDTO = new ServiceMasterDTO();
            masterDTO.setServiceid(master.getServiceid());
            masterDTO.setPrice(master.getPrice());
            masterDTO.setServicename(master.getServicename());
            masterDTO.setActive(master.getActive());
            serviceMasterDTOList.add(masterDTO);
        });
        return serviceMasterDTOList;
    }

    public List<ServiceMasterDTO> getAllServiceMasterData(Integer pageNumber,Integer pageSize){
        Pageable paging = PageRequest.of(pageNumber, pageSize);
        Page<ServiceMasterModel> serviceMasterResult = serviceMasterRepository.findAll(paging);
        List<ServiceMasterDTO> serviceMasterDTOList = new ArrayList<>();
        serviceMasterResult.forEach(master->{
            ServiceMasterDTO masterDTO = new ServiceMasterDTO();
            masterDTO.setServiceid(master.getServiceid());
            masterDTO.setPrice(master.getPrice());
            masterDTO.setServicename(master.getServicename());
            masterDTO.setActive(master.getActive());
            serviceMasterDTOList.add(masterDTO);
        });
        return serviceMasterDTOList;
    }


    public List<SpecilaityMasterDTO> getSpecilaityMasterDetails(){
        List<SpecilaityMasterModel> specilaityMasterModelDetails = specilaityMasterRepository.getSpecilaityMasterData();
        List<SpecilaityMasterDTO> specilaityMasterDtos = new ArrayList<>();
        specilaityMasterModelDetails.forEach(specilty->{
            SpecilaityMasterDTO specilaityMasterDTO = new SpecilaityMasterDTO();
            specilaityMasterDTO.setSpecilaityname(specilty.getSpecilaityname());
            specilaityMasterDTO.setSpecilaityid(specilty.getSpecilaityid());
            specilaityMasterDTO.setStatus(specilty.getStatus());
            specilaityMasterDtos.add(specilaityMasterDTO);
        });
        return specilaityMasterDtos;
    }

    public List<CountriesDTO> getCountries(){
        List<CountriesModel> countriesModel = lookUpRepositaory.getCountries();
        List<CountriesDTO> CountriesMasterList = new ArrayList<>();
        countriesModel.forEach(country->{
            CountriesDTO countriesDTO = new CountriesDTO();
            countriesDTO.setCountryid(country.getCountryid());
            countriesDTO.setCountryname(country.getCountryname());
            countriesDTO.setStatus(country.getStatus());
            CountriesMasterList.add(countriesDTO);
        });
        return CountriesMasterList;
    }

    public List<StateDTO> getStates(Long countryId){
        List<StateModel> countriesModel = lookUpRepositaory.getStates(countryId);
        List<StateDTO> stateModelList = new ArrayList<>();
        countriesModel.forEach(state->{
            StateDTO stateDTO = new StateDTO();
            stateDTO.setCountryid(state.getCountryid());
            stateDTO.setStatecode(state.getStatecode());
            stateDTO.setStatus(state.getStatus());
            stateDTO.setStateid(state.getStateid());
            stateDTO.setStatename(state.getStatename());
            stateModelList.add(stateDTO);
        });
        return stateModelList;
    }

    public List<CityDTO> getCities(Long stateId){
        List<CityModel> cityModelList = lookUpRepositaory.getCities(stateId);
        List<CityDTO> cityDTOList = new ArrayList<>();
        cityModelList.forEach(city->{
            CityDTO cityDTO = new CityDTO();
            cityDTO.setCityid(city.getCityid());
            cityDTO.setStatus(city.getStatus());
            cityDTO.setStateid(city.getStateid());
            cityDTO.setCitycode(city.getCitycode());
            cityDTO.setCityname(city.getCityname());
            cityDTOList.add(cityDTO);
        });
        return cityDTOList;
    }

    public List<MasterDataDTO> getMasterDataBasedCode(String code){
       List<MasterDataModel> masterDataModelsList =  masterDataRepository.findMasterDataModelByMastercode(code);
       List<MasterDataDTO> masterDataDTOSList = new ArrayList<>();
        masterDataModelsList.forEach(master->{
            MasterDataDTO masterDataDTO = new MasterDataDTO();
            masterDataDTO.setMastercode(master.getMastercode());
            masterDataDTO.setMasterdatavalue(master.getMasterdatavalue());
            masterDataDTO.setActive(master.getActive());
            masterDataDTO.setId(master.getId());
            masterDataDTOSList.add(masterDataDTO);
        });
        return masterDataDTOSList;
    }

    public List<TaskActionsModel> getRolesAndTasks(String code){
        List<TaskActionsModel> rollesResponse = taskActionsRepository.findAll();
        return rollesResponse;
    }

    @Transactional
    public List<RolesAndTaskResponseModel> getRolesAndTasksTransBasedonRoleId(Long roleid){
        List<RolesAndTaskResponseModel> rollesResponse = rolesAndTaskResponseRepository.GET_ROLES_TASKS_BASED_ON_ROLE(roleid);

        return rollesResponse;
    }

    @Transactional
    public  Boolean saveRolesTasks(List<RoletaksactionsDTO> roletaksactionsDTO){
        List<RoleTaksActionsModel> list = new ArrayList<>();
        roletaksactionsDTO.forEach(item->{
            RoleTaksActionsModel roleTaksActionsModel = new RoleTaksActionsModel();
            roleTaksActionsModel.setIspermission(item.getIspermission());
            roleTaksActionsModel.setRoleid(item.getRoleid());
            roleTaksActionsModel.setTaskid(item.getTaskid());
            roleTaksActionsModel.setRoletaskactionid(item.getRoletaskactionid());
            roleTaksActionsModel.setStatus(item.getStatus());
            list.add(roleTaksActionsModel);
        });
        roleTaksActionsRepository.saveAll(list);
        return true;
    }




}
