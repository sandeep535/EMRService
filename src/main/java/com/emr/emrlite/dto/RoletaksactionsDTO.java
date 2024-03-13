package com.emr.emrlite.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class RoletaksactionsDTO {
    private Long roletaskactionid;
    private Long taskid;
    private Long roleid;
    private Integer status;
    private Boolean ispermission;
    private Boolean defaultoption;
    private Boolean defaultoptionvalue;
}
