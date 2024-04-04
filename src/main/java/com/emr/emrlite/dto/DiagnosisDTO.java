package com.emr.emrlite.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiagnosisDTO {
    Long diagnosisid;
    String description;
    Long clientid;
    Long visitid;
    Integer status;
	public Long getDiagnosisid() {
		return diagnosisid;
	}
	public void setDiagnosisid(Long diagnosisid) {
		this.diagnosisid = diagnosisid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getClientid() {
		return clientid;
	}
	public void setClientid(Long clientid) {
		this.clientid = clientid;
	}
	public Long getVisitid() {
		return visitid;
	}
	public void setVisitid(Long visitid) {
		this.visitid = visitid;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
    
    
}
