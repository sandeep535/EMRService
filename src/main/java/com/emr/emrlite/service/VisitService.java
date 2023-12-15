package com.emr.emrlite.service;


import com.emr.emrlite.dto.RegistrationDTO;
import com.emr.emrlite.dto.VisitDetailsDTO;
import com.emr.emrlite.model.RegistrationModel;
import com.emr.emrlite.model.VisitDetailsModel;
import com.emr.emrlite.model.VisitServicesModel;
import com.emr.emrlite.repository.RegistrationRepository;
import com.emr.emrlite.repository.VisitDetailsRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class VisitService {
    private final VisitDetailsRepository visitDetailsRepository;
    private final RegistrationService registrationService;
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
        visitDetailsRepository.save(visitDetailsModel);
        v.setVisitid(visitDetailsModel.getVisitid());
        return v;
    }

    public List<VisitDetailsDTO> getVisists(Integer pageNumber,Integer pageSize){
        List<VisitDetailsDTO> visitDetailsListDTO = new ArrayList<>();
        PageRequest pageRequest = PageRequest.of(pageNumber,pageSize);
       Page<VisitDetailsModel> vistsModelList = visitDetailsRepository.findAll(pageRequest);
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
            visitDetailsListDTO.add(visitDetailsDTO);
        });
        return visitDetailsListDTO;
    }
}
