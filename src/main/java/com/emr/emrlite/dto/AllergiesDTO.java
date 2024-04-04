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
	public Long getAllergyid() {
		return allergyid;
	}
	public void setAllergyid(Long allergyid) {
		this.allergyid = allergyid;
	}
	public String getAllergy() {
		return allergy;
	}
	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getIndications() {
		return indications;
	}
	public void setIndications(String indications) {
		this.indications = indications;
	}
	public LookUpModel getSeverity() {
		return severity;
	}
	public void setSeverity(LookUpModel severity) {
		this.severity = severity;
	}
	public Long getVisitid() {
		return visitid;
	}
	public void setVisitid(Long visitid) {
		this.visitid = visitid;
	}
	public Long getClientid() {
		return clientid;
	}
	public void setClientid(Long clientid) {
		this.clientid = clientid;
	}
    
    
}
