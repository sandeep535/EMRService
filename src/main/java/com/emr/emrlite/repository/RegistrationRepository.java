package com.emr.emrlite.repository;

import com.emr.emrlite.dto.RegistrationDTO;
import com.emr.emrlite.model.AddressModel;
import com.emr.emrlite.model.RegistrationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RegistrationRepository extends JpaRepository<RegistrationModel,Long> {
    @Query("SELECT u FROM RegistrationModel u WHERE u.contact like %:mobileNumber%")
    List<RegistrationModel> getDataBasedOnMobileNumber(String mobileNumber);
}
