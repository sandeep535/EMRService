package com.emr.emrlite.service;

import com.emr.emrlite.dto.RegistrationDTO;
import com.emr.emrlite.model.AddressModel;
import com.emr.emrlite.model.BaseEntity;
import com.emr.emrlite.model.RegistrationModel;
import com.emr.emrlite.repository.RegistrationRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class RegistrationService extends BaseEntity {

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
        if(registrationDTO.getAddress() != null){
            AddressModel a = new AddressModel();
            a.setAddress1(registrationDTO.getAddress().getAddress1());
            a.setAddress2(registrationDTO.getAddress().getAddress2());
            a.setCity(registrationDTO.getAddress().getCity());
            a.setCountry(registrationDTO.getAddress().getCountry());
            a.setState(registrationDTO.getAddress().getState());
            a.setPincode(registrationDTO.getAddress().getPincode());
            r.setAddress(a);
        }

        registrationRepository.save(r);
        RegistrationDTO resultDTO = new RegistrationDTO();
        resultDTO.setSeqid(r.getSeqid());
        return resultDTO;
    }

    public List<RegistrationDTO> getClientDataBasedonmobilenumber(String mobilenumber){
        List<RegistrationDTO> clientList = new ArrayList<>();
        List<RegistrationModel> d1 = registrationRepository.getDataBasedOnMobileNumber(mobilenumber);
        d1.forEach(client-> {
            RegistrationDTO d = new RegistrationDTO();
            d.setEmail(client.getEmail());
            d.setFirstname(client.getFirstname());
            d.setLastname(client.getLastname());
            d.setGender(client.getGender());
            d.setContact(client.getContact());
            d.setAge(client.getAge());
            d.setTitle(client.getTitle());
            d.setSeqid(client.getSeqid());
            d.setDob(client.getDob());
            AddressModel a = new AddressModel();
            if(client.getAddress() != null && null != client.getAddress().getCity()){
                a.setAddress1(client.getAddress().getAddress1());
                a.setAddress2(client.getAddress().getAddress2());
                a.setCity(client.getAddress().getCity());
                a.setCountry(client.getAddress().getCountry());
                a.setPincode(client.getAddress().getPincode());
                a.setState(client.getAddress().getState());
                d.setAddress(a);
            }
            clientList.add(d);
        });


        return clientList;
    }
}
