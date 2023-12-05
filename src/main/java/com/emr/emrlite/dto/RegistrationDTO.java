package com.emr.emrlite.dto;

import com.emr.emrlite.model.AddressModel;
import com.emr.emrlite.model.LookUpModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDTO {
    private Long id;
    private LookUpModel title;
    private String firstname;
    private String lastname;
    private LookUpModel gender;
    private Integer contact;
    private String email;
    private String dob;
    private Integer age;
    private AddressModel address;
}
