package com.emr.emrlite.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LookUpDTO {
    private Long lookupid;
    private String lookupcode;
    private String lookupvalue;
    private String lookuptype;
}
