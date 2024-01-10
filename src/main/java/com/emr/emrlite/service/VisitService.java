package com.emr.emrlite.service;


import com.emr.emrlite.dto.*;
import com.emr.emrlite.model.*;
import com.emr.emrlite.repository.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class VisitService {
    private final VisitDetailsRepository visitDetailsRepository;
    private final RegistrationService registrationService;
    private final VitalsRepository vitalsRepository;
    private final NotesRepository notesRepository;
    private final DiagnosisRepository diagnosisRepository;
    private final AllergiesRepository allergiesRepository;
    private final DrugsService drugsService;
    public VisitDetailsDTO saveVisit(VisitDetailsDTO visitDetailsDTO){
        if(visitDetailsDTO.getClientid().getSeqid() == null){
            RegistrationDTO registrationDTO = new RegistrationDTO();
            registrationDTO.setAge(visitDetailsDTO.getClientid().getAge());
            registrationDTO.setContact(visitDetailsDTO.getClientid().getContact());
            registrationDTO.setEmail(visitDetailsDTO.getClientid().getEmail());
            registrationDTO.setLastname(visitDetailsDTO.getClientid().getLastname());
            registrationDTO.setFirstname(visitDetailsDTO.getClientid().getFirstname());
            registrationDTO.setTitle(visitDetailsDTO.getClientid().getTitle());
            registrationDTO.setDob(visitDetailsDTO.getClientid().getDob());
            registrationDTO.setGender(visitDetailsDTO.getClientid().getGender());
            registrationDTO.setAddress(visitDetailsDTO.getClientid().getAddress());
            RegistrationDTO d = registrationService.saveregistation(registrationDTO);
            registrationDTO.setSeqid(d.getSeqid());
            RegistrationModel r = new RegistrationModel();
            r.setSeqid(d.getSeqid());
            visitDetailsDTO.setClientid(r);
        }
        VisitDetailsDTO v = new VisitDetailsDTO();
        VisitDetailsModel visitDetailsModel = new VisitDetailsModel();
        visitDetailsModel.setSpecilaity(visitDetailsDTO.getSpecilaity());
        visitDetailsModel.setDoctor(visitDetailsDTO.getDoctor());
        visitDetailsModel.setStatus(1);
        visitDetailsModel.setReason(visitDetailsDTO.getReason());
        visitDetailsModel.setVisitdate(visitDetailsDTO.getVisitdate());
        visitDetailsModel.setClientid(visitDetailsDTO.getClientid());
        visitDetailsModel.setVisitdiscount(visitDetailsDTO.getVisitdiscount());
        visitDetailsModel.setVisittotalamount(visitDetailsDTO.getVisittotalamount());
        visitDetailsModel.setVisittype(visitDetailsDTO.getVisittype());
        visitDetailsModel.setServices(visitDetailsDTO.getServices());
        visitDetailsModel.setToken(visitDetailsDTO.getToken());
        visitDetailsModel.setStatus(1);
        visitDetailsRepository.save(visitDetailsModel);
        v.setVisitid(visitDetailsModel.getVisitid());
        return v;
    }

    public List<VisitDetailsDTO> getVisists(Date fromdate, Date todate, Integer pageNumber, Integer pageSize){
        List<VisitDetailsDTO> visitDetailsListDTO = new ArrayList<>();
      //  PageRequest pageRequest = PageRequest.of(pageNumber,pageSize);
        List<VisitDetailsModel> vistsModelList = visitDetailsRepository.getVisitDeatils(fromdate,todate);
        vistsModelList.forEach(visit->{
            VisitDetailsDTO visitDetailsDTO = new VisitDetailsDTO();
            visitDetailsDTO.setVisitid(visit.getVisitid());
            visitDetailsDTO.setDoctor(visit.getDoctor());
            visitDetailsDTO.setServices(visit.getServices());
            visitDetailsDTO.setReason(visit.getReason());
            visitDetailsDTO.setStatus(visit.getStatus());
            visitDetailsDTO.setClientid(visit.getClientid());
            visitDetailsDTO.setSpecilaity(visit.getSpecilaity());
            visitDetailsDTO.setVisitdate(visit.getVisitdate());
            visitDetailsDTO.setVisittype(visit.getVisittype());
            visitDetailsDTO.setVisitdiscount(visit.getVisitdiscount());
            visitDetailsDTO.setVisittotalamount(visit.getVisittotalamount());
            visitDetailsDTO.setToken(visit.getToken());
            visitDetailsListDTO.add(visitDetailsDTO);
        });
        return visitDetailsListDTO;
    }

    public Integer updateVisitStatus (Long visitID,Integer visitStatusId){
        Integer result = visitDetailsRepository.updateVisitStatus(visitID,visitStatusId);
        return result;
    }

    public VitalsDTO saveVitals (VitalsDTO vitalsDTO){
        VitalsModel vitalsModel = new VitalsModel();
        vitalsModel.setBmi(vitalsDTO.getBmi());
        vitalsModel.setPulse(vitalsDTO.getPulse());
        vitalsModel.setCapturedby(vitalsDTO.getCapturedby());
        vitalsModel.setHeight(vitalsDTO.getHeight());
        vitalsModel.setDiastolic(vitalsDTO.getDiastolic());
        vitalsModel.setSystolic(vitalsDTO.getSystolic());
        vitalsModel.setRespiratoryrate(vitalsDTO.getRespiratoryrate());
        vitalsModel.setTemperature(vitalsDTO.getTemperature());
        vitalsModel.setWeight(vitalsDTO.getWeight());
         vitalsModel.setVitalid(vitalsDTO.getVitalid());
        vitalsModel.setVisitid(vitalsDTO.getVisitid());
        vitalsModel.setClientid(vitalsDTO.getClientid());
        vitalsRepository.save(vitalsModel);
        VitalsDTO resultDTO = new VitalsDTO();
        resultDTO.setVitalid(vitalsModel.getVitalid());
        //Integer result = visitDetailsRepository.updateVisitStatus(visitID,visitStatusId);
        return resultDTO;
    }
    public NotesDTO saveNotes (NotesDTO notesDTO){
        NotesModel notesModel = new NotesModel();
        notesModel.setDescription(notesDTO.getDescription());
        notesModel.setVisitid(notesDTO.getVisitid());
        notesModel.setClientid(notesDTO.getClientid());
        notesModel.setStatus(1);
        notesModel.setNotesid(notesDTO.getNotesid());
        notesRepository.save(notesModel);
        NotesDTO notesDTO1 = new NotesDTO();
        notesDTO1.setNotesid(notesModel.getNotesid());
        return notesDTO1;
    }
    public DiagnosisDTO saveDiagnosis (DiagnosisDTO diagnosisDTO){
        DiagnosisModel diagnosisModel = new DiagnosisModel();
        diagnosisModel.setDescription(diagnosisDTO.getDescription());
        diagnosisModel.setClientid(diagnosisDTO.getClientid());
        diagnosisModel.setVisitid(diagnosisDTO.getVisitid());
        diagnosisModel.setStatus(1);
        diagnosisModel.setDiagnosisid(diagnosisDTO.getDiagnosisid());
        diagnosisRepository.save(diagnosisModel);
        DiagnosisDTO diagnosisDTOresult = new DiagnosisDTO();
        diagnosisDTOresult.setDiagnosisid(diagnosisModel.getDiagnosisid());
        return diagnosisDTOresult;
    }

    public void saveVisitData (SaveVisitDataDTO saveVisitDataDTO){
        VitalsDTO vitalsDTO = new VitalsDTO();
        vitalsDTO.setHeight(saveVisitDataDTO.getVitalsDTO().getHeight());
        vitalsDTO.setDiastolic(saveVisitDataDTO.getVitalsDTO().getDiastolic());
        vitalsDTO.setPulse(saveVisitDataDTO.getVitalsDTO().getPulse());
        vitalsDTO.setTemperature(saveVisitDataDTO.getVitalsDTO().getTemperature());
        vitalsDTO.setSystolic(saveVisitDataDTO.getVitalsDTO().getSystolic());
        vitalsDTO.setRespiratoryrate(saveVisitDataDTO.getVitalsDTO().getRespiratoryrate());
        vitalsDTO.setWeight(saveVisitDataDTO.getVitalsDTO().getWeight());
        vitalsDTO.setBmi(saveVisitDataDTO.getVitalsDTO().getBmi());
        vitalsDTO.setCapturedby(saveVisitDataDTO.getCapturedby());
        vitalsDTO.setVisitid(saveVisitDataDTO.getVisitid());
        vitalsDTO.setClientid(saveVisitDataDTO.getClientid());
        vitalsDTO.setVitalid(saveVisitDataDTO.getVitalsDTO().getVitalid());
        saveVitals(vitalsDTO);

        NotesDTO notesDTO = new NotesDTO();
        notesDTO.setStatus(1);
        notesDTO.setClientid(saveVisitDataDTO.getClientid());
        notesDTO.setVisitid(saveVisitDataDTO.getVisitid());
        notesDTO.setDescription(saveVisitDataDTO.getNotesDTO().getDescription());
        notesDTO.setNotesid(saveVisitDataDTO.getNotesDTO().getNotesid());
        saveNotes(notesDTO);

        DiagnosisDTO diagnosisDTO = new DiagnosisDTO();
        diagnosisDTO.setVisitid(saveVisitDataDTO.getVisitid());
        diagnosisDTO.setDescription(saveVisitDataDTO.getDiagnosisDTO().getDescription());
        diagnosisDTO.setStatus(1);
        diagnosisDTO.setClientid(saveVisitDataDTO.getClientid());
        diagnosisDTO.setDiagnosisid(saveVisitDataDTO.getDiagnosisDTO().getDiagnosisid());
        saveDiagnosis(diagnosisDTO);

        List<PrescriptionsDTO> PrescriptionsDTOList = new ArrayList<>();
        saveVisitDataDTO.getPrescriptions().forEach(cprescription->{
            PrescriptionsDTO prescriptionsDTO = new PrescriptionsDTO();
            prescriptionsDTO.setCapturedby(saveVisitDataDTO.getCapturedby());
            prescriptionsDTO.setDose(cprescription.getDose());
            prescriptionsDTO.setClientid(saveVisitDataDTO.getClientid());
            prescriptionsDTO.setEndate(cprescription.getEndate());
            prescriptionsDTO.setDoseunit(cprescription.getDoseunit());
            prescriptionsDTO.setInstructions(cprescription.getInstructions());
            prescriptionsDTO.setSig(cprescription.getSig());
            prescriptionsDTO.setStartdate(cprescription.getStartdate());
            prescriptionsDTO.setPrescriptionid(cprescription.getPrescriptionid());
            prescriptionsDTO.setVisitid(saveVisitDataDTO.getVisitid());
            prescriptionsDTO.setDrugid(cprescription.getDrugid());
            prescriptionsDTO.setDrugname(cprescription.getDrugname());
            prescriptionsDTO.setStatus(1);
            PrescriptionsDTOList.add(prescriptionsDTO);
        });
        drugsService.savePrescriptions(PrescriptionsDTOList);

        if(saveVisitDataDTO.getAllergies() != null){
            //saveVisitDataDTO.setAllergies();setVisitid(saveVisitDataDTO.getVisitid());
            saveVisitDataDTO.setClientid(saveVisitDataDTO.getClientid());
            saveAllergies(saveVisitDataDTO.getAllergies());
        }

    }

    public List<VitalsDTO> getVitals(Long visitId,Long clientid){
        List<VitalsModel> vitalsModelList = null;
        if(visitId != 0){
             vitalsModelList = vitalsRepository.findByVisitid(visitId);
        }else{
            vitalsModelList = vitalsRepository.findAllByClientid(clientid);
        }
        List<VitalsDTO> vitalsDTOListRes = new ArrayList<>();
        if(vitalsModelList != null){
            vitalsModelList.forEach(vitalsModel->{
                VitalsDTO vitalsDTO = new VitalsDTO();
                if(vitalsModel != null){
                    vitalsDTO.setWeight(vitalsModel.getWeight());
                    vitalsDTO.setVitalid(vitalsModel.getVitalid());
                    vitalsDTO.setBmi(vitalsModel.getBmi());
                    vitalsDTO.setHeight(vitalsModel.getHeight());
                    vitalsDTO.setPulse(vitalsModel.getPulse());
                    vitalsDTO.setDiastolic(vitalsModel.getDiastolic());
                    vitalsDTO.setRespiratoryrate(vitalsModel.getRespiratoryrate());
                    vitalsDTO.setTemperature(vitalsModel.getTemperature());
                    vitalsDTO.setSystolic(vitalsModel.getSystolic());
                    vitalsDTO.setClientid(vitalsModel.getClientid());
                    vitalsDTO.setCapturedby(vitalsModel.getCapturedby());
                    vitalsDTOListRes.add(vitalsDTO);
                }else{
                    vitalsDTO = null;
                }
            });
        }
        return vitalsDTOListRes;
    }

    public NotesDTO getNotes(Long visitid){
    NotesModel notesModel = notesRepository.getNotes(visitid);
        NotesDTO notesDTO = new NotesDTO();
    if(notesModel != null) {
        notesDTO.setNotesid(notesModel.getNotesid());
        notesDTO.setStatus(notesModel.getStatus());
        notesDTO.setClientid(notesModel.getClientid());
        notesDTO.setDescription(notesModel.getDescription());
        notesDTO.setVisitid(notesModel.getVisitid());
    }else{
        notesDTO = null;
    }
        return notesDTO;
    }

    public DiagnosisDTO getDiagnosis(Long visitid){
       DiagnosisModel diagnosisModel = diagnosisRepository.findDiagnosisModelByVisitid(visitid);
        DiagnosisDTO diagnosisDTO = new DiagnosisDTO();
       if(diagnosisModel != null) {
           diagnosisDTO.setClientid(diagnosisModel.getClientid());
           diagnosisDTO.setDiagnosisid(diagnosisModel.getDiagnosisid());
           diagnosisDTO.setVisitid(diagnosisModel.getVisitid());
           diagnosisDTO.setDescription(diagnosisModel.getDescription());
           diagnosisDTO.setStatus(diagnosisModel.getStatus());
       }else{
           diagnosisDTO = null;
       }
        return diagnosisDTO;
    }

    public String saveAllergies(List<AllergiesModel> allergiesDTOSList){
        allergiesRepository.saveAll(allergiesDTOSList);
        return "Saved";
    }
    public  List<AllergiesModel> getAllergies(Long visitid,Long clientid){
        List<AllergiesModel> allergiesModelsList = null;
        if(visitid !=0){
            allergiesModelsList = allergiesRepository.findAllergiesModelByVisitid(visitid);
        }
        if(clientid !=0){
            allergiesModelsList = allergiesRepository.findAllergiesModelByClientid(clientid);
        }
        return allergiesModelsList;
       // allergiesRepository.findAllBy
    }

}
