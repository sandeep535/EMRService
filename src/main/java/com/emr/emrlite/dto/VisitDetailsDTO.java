package com.emr.emrlite.dto;

import com.emr.emrlite.model.EmployeeModel;
import com.emr.emrlite.model.LookUpModel;
import com.emr.emrlite.model.SpecilaityMasterModel;
import com.emr.emrlite.model.VisitServicesModel;
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
    private Long clientid;
    private Set<VisitServicesModel> services;
}
