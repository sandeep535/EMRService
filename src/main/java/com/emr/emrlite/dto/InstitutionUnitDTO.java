package com.emr.emrlite.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstitutionUnitDTO {
	 private String name;
	    private String code;
	    private Long parentId;
	    private Boolean isBed;
	    private Double bedCost;
	    private Boolean isOccupied;
}
