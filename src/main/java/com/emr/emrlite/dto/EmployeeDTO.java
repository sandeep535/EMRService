package com.emr.emrlite.dto;


import com.emr.emrlite.model.LookUpModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private Long id;
    private Integer empid;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private LookUpModel title;
    private LookUpModel designation;
    private LookUpModel gender;
}
