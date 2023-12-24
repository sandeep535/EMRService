package com.emr.emrlite.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DrugMasterDTO {
    Long drugid;
    String drugname;
    Integer status;
    String drugcode;
}
