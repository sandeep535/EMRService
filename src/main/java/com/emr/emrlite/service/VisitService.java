package com.emr.emrlite.service;


import com.emr.emrlite.dto.RegistrationDTO;
import com.emr.emrlite.dto.VisitDetailsDTO;
import com.emr.emrlite.model.VisitDetailsModel;
import com.emr.emrlite.model.VisitServicesModel;
import com.emr.emrlite.repository.RegistrationRepository;
import com.emr.emrlite.repository.VisitDetailsRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class VisitService {
    private final VisitDetailsRepository visitDetailsRepository;
    public VisitDetailsDTO saveVisit(VisitDetailsDTO visitDetailsDTO){
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
}
