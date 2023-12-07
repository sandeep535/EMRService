package com.emr.emrlite.service;

import com.emr.emrlite.dto.*;
import com.emr.emrlite.model.EmployeeModel;
import com.emr.emrlite.model.LookUpModel;
import com.emr.emrlite.model.ServiceMasterModel;
import com.emr.emrlite.model.SpecilaityMasterModel;
import com.emr.emrlite.repository.EmployeeRepository;
import com.emr.emrlite.repository.LookUpRepository;
import com.emr.emrlite.repository.ServiceMasterRepository;
import com.emr.emrlite.repository.SpecilaityMasterRepository;
import lombok.RequiredArgsConstructor;
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
            lookup.setLookupcode(item.getLookupcode());
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
            resultDTO.add(empDetails);
        });
        return resultDTO;
    }

    public List<ServiceMasterDTO> getServiceMasterData(){
        List<ServiceMasterModel> serviceMasterResult = serviceMasterRepository.getServiceMasterData();
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

}
