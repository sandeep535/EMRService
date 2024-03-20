package com.emr.emrlite.service;

import com.emr.emrlite.dto.DrugMasterDTO;
import com.emr.emrlite.dto.EmployeeDTO;
import com.emr.emrlite.dto.PrescriptionsDTO;
import com.emr.emrlite.model.DrugsMasterModel;
import com.emr.emrlite.model.EmployeeModel;
import com.emr.emrlite.model.PrescriptionsModel;
import com.emr.emrlite.repository.DrugMasterRepository;
import com.emr.emrlite.repository.LookUpRepository;
import com.emr.emrlite.repository.PrescriptionsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DrugsService {
    private final DrugMasterRepository drugMasterRepository;
    private final PrescriptionsRepository prescriptionsRepository;
        public List<DrugMasterDTO> getDrugMasterData(String drugname){
            List<DrugsMasterModel> result = drugMasterRepository.getDrugMasterData(drugname);
            List<DrugMasterDTO> drugMasterDTOList = new ArrayList<>();
            result.forEach(drug-> {
                DrugMasterDTO drugDTO = new DrugMasterDTO();
                drugDTO.setDrugcode(drug.getDrugcode());
                drugDTO.setDrugname(drug.getDrugname());
                drugDTO.setDrugid(drug.getDrugid());
                drugDTO.setStatus(drug.getStatus());
                drugMasterDTOList.add(drugDTO);
            });
        return drugMasterDTOList;
    }

    public DrugsMasterModel saveDrugMasterData(DrugsMasterModel drugsMasterModel){
        drugMasterRepository.save(drugsMasterModel);
        DrugsMasterModel result = new DrugsMasterModel();
        result.setDrugid(drugsMasterModel.getDrugid());
            return result;
    }
    public DrugsMasterModel checkDuplicateDrugname(String drugName){
        DrugsMasterModel DdrugsMasterModel = drugMasterRepository.findDrugsMasterModelByDrugname(drugName);
        return DdrugsMasterModel;
    }

    public DrugsMasterModel checkDuplicateDrugcode(String drugCode){
        DrugsMasterModel DdrugsMasterModel = drugMasterRepository.findDrugsMasterModelByDrugcode(drugCode);
        return DdrugsMasterModel;
    }
    public List<PrescriptionsDTO> savePrescriptions(List<PrescriptionsDTO> PrescriptionsDTORequestList){
            List<PrescriptionsModel> prescriptionsModelsList = new ArrayList<>();
        PrescriptionsDTORequestList.forEach(prescription->{
                PrescriptionsModel prescriptionsModel = new PrescriptionsModel();
                prescriptionsModel.setCapturedby(prescription.getCapturedby());
                prescriptionsModel.setDose(prescription.getDose());
                prescriptionsModel.setClientid(prescription.getClientid());
                prescriptionsModel.setEndate(prescription.getEndate());
                prescriptionsModel.setDoseunit(prescription.getDoseunit());
                prescriptionsModel.setInstructions(prescription.getInstructions());
                prescriptionsModel.setSig(prescription.getSig());
                prescriptionsModel.setStartdate(prescription.getStartdate());
                prescriptionsModel.setPrescriptionid(prescription.getPrescriptionid());
                prescriptionsModel.setVisitid(prescription.getVisitid());
                prescriptionsModel.setDrugid(prescription.getDrugid());
                prescriptionsModel.setDrugname(prescription.getDrugname());
                prescriptionsModel.setStatus(1);
                prescriptionsModelsList.add(prescriptionsModel);
        });
        prescriptionsRepository.saveAll(prescriptionsModelsList);
        return PrescriptionsDTORequestList;
    }

    public  List<PrescriptionsDTO> getPrescriptions(Long visitid,Long clientid){
        List<PrescriptionsModel> prescriptionsModelsList = null;
            if(visitid !=0 ){
                 prescriptionsModelsList = prescriptionsRepository.findByVisitid(visitid);
            }else{
                 prescriptionsModelsList = prescriptionsRepository.findByClientid(clientid);
            }

        List<PrescriptionsDTO> prescriptionsDTOSResult;
           if(prescriptionsModelsList != null){
                prescriptionsDTOSResult = new ArrayList<>();
               prescriptionsModelsList.forEach(prescription->{
                   PrescriptionsDTO prescriptionsDTO = new PrescriptionsDTO();
                   prescriptionsDTO.setCapturedby(prescription.getCapturedby());
                   prescriptionsDTO.setDose(prescription.getDose());
                   prescriptionsDTO.setClientid(prescription.getClientid());
                   prescriptionsDTO.setEndate(prescription.getEndate());
                   prescriptionsDTO.setDoseunit(prescription.getDoseunit());
                   prescriptionsDTO.setInstructions(prescription.getInstructions());
                   prescriptionsDTO.setSig(prescription.getSig());
                   prescriptionsDTO.setStartdate(prescription.getStartdate());
                   prescriptionsDTO.setPrescriptionid(prescription.getPrescriptionid());
                   prescriptionsDTO.setVisitid(prescription.getVisitid());
                   prescriptionsDTO.setDrugid(prescription.getDrugid());
                   prescriptionsDTO.setStatus(prescription.getStatus());
                   prescriptionsDTO.setDrugname(prescription.getDrugname());
                   prescriptionsDTOSResult.add(prescriptionsDTO);
               });
           }else{
               prescriptionsDTOSResult = null;
           }
            return prescriptionsDTOSResult;
    }
}
