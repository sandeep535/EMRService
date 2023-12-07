package com.emr.emrlite.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceMasterDTO {
    private Long serviceid;
    private String servicename;
    private Float price;
    private Integer active;
}
