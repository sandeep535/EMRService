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
public class VisitServicesDTO {

    private Long id;
    private Long visitid;
    private Long serviceid;
    private Float serviceprice;
    private Float servicediscount;
    private Float quantity;
    private Float servicetotalamount;
    private Integer status;
}
