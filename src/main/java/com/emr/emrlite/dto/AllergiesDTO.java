package com.emr.emrlite.dto;

import com.emr.emrlite.model.LookUpModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllergiesDTO {
    private Long allergyid;
    String allergy;
    Integer status;
    String indications;
    private LookUpModel severity;
    private Long visitid;
    private Long clientid;
}
