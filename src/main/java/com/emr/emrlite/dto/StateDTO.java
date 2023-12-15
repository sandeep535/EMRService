package com.emr.emrlite.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StateDTO {
    private Long stateid;
    private String statename;
    private String statecode;
    private Long countryid;
    private Integer status;
}
