package com.emr.emrlite.dto;

import com.emr.emrlite.model.LookUpModel;
import com.emr.emrlite.model.MasterDataModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDTO {
    private Long id;
    private Integer empid;
    private String firstname;
    private String lastname;
    private String username;
    private LookUpModel title;
    private LookUpModel designation;
    private LookUpModel gender;
    private MasterDataModel role;
    private String token;
}
