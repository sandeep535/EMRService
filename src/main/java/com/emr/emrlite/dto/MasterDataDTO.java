package com.emr.emrlite.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MasterDataDTO {
    private Long id;
    private String mastercode;
    private String masterdatavalue;
    private Integer active;
}
