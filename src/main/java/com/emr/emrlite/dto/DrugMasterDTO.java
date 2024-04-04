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
	public Long getDrugid() {
		return drugid;
	}
	public void setDrugid(Long drugid) {
		this.drugid = drugid;
	}
	public String getDrugname() {
		return drugname;
	}
	public void setDrugname(String drugname) {
		this.drugname = drugname;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getDrugcode() {
		return drugcode;
	}
	public void setDrugcode(String drugcode) {
		this.drugcode = drugcode;
	}
    
}
