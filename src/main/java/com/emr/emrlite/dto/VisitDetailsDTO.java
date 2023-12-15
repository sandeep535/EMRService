package com.emr.emrlite.dto;

import com.emr.emrlite.model.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class VisitDetailsDTO {

    private Long visitid;
    private Date visitdate;
    private EmployeeModel doctor;
    private LookUpModel visittype;
    private SpecilaityMasterModel specilaity;
    private Float visitdiscount;
    private Float visittotalamount;
    private String reason;
    private Integer status;
    private RegistrationModel clientid;
    private Set<VisitServicesModel> services;
}
