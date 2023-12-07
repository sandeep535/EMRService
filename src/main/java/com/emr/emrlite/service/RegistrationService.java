package com.emr.emrlite.service;

import com.emr.emrlite.dto.RegistrationDTO;
import com.emr.emrlite.model.AddressModel;
import com.emr.emrlite.model.RegistrationModel;
import com.emr.emrlite.repository.RegistrationRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class RegistrationService {

    private final RegistrationRepository registrationRepository;
    public RegistrationDTO saveregistation(RegistrationDTO registrationDTO){
        RegistrationModel r = new RegistrationModel();
        r.setFirstname(registrationDTO.getFirstname());
        r.setLastname(registrationDTO.getLastname());
        r.setGender(registrationDTO.getGender());
        r.setContact(registrationDTO.getContact());
        r.setEmail(registrationDTO.getEmail());
        r.setDob(registrationDTO.getDob());
        r.setAge(registrationDTO.getAge());
        r.setTitle(registrationDTO.getTitle());
        AddressModel a = new AddressModel();
        a.setAddress1(registrationDTO.getAddress().getAddress1());
        a.setAddress2(registrationDTO.getAddress().getAddress2());
        a.setCity(registrationDTO.getAddress().getCity());
        a.setCountry(registrationDTO.getAddress().getCountry());
        r.setAddress(a);
        registrationRepository.save(r);
        RegistrationDTO resultDTO = new RegistrationDTO();
        resultDTO.setSeqid(r.getSeqid());
        return resultDTO;
    }

    public RegistrationDTO getClientDataBasedonmobilenumber(String mobilenumber){
        RegistrationDTO d = new RegistrationDTO();
        Optional<RegistrationModel> d1 = Optional.ofNullable(registrationRepository.getDataBasedOnMobileNumber(mobilenumber));
        d.setEmail(d1.get().getEmail());
        d.setFirstname(d1.get().getFirstname());
        d.setLastname(d1.get().getLastname());
        d.setGender(d1.get().getGender());
        d.setContact(d1.get().getContact());
        d.setAge(d1.get().getAge());
        d.setTitle(d1.get().getTitle());
        AddressModel a = new AddressModel();
        if(d1.get().getAddress() != null && null != d1.get().getAddress().getCity()){
            a.setAddress1(d1.get().getAddress().getAddress1());
            a.setAddress2(d1.get().getAddress().getAddress2());
            a.setCity(d1.get().getAddress().getCity());
            a.setCountry(d1.get().getAddress().getCountry());
            d.setAddress(a);
        }
        return d;
    }
}
