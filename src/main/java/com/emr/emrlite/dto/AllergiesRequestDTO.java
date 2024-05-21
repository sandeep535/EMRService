package com.emr.emrlite.dto;

import java.util.List;

import com.emr.emrlite.model.AllergiesModel;
import com.emr.emrlite.model.LookUpModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllergiesRequestDTO {
	Integer pagenumber;
	Integer pagesize;
	Long totalcount;
	private Long visitid;
    private Long clientid;
    String allergy;
    Integer status;
    String indications;
    private LookUpModel severity;
	List<AllergiesModel> allergieslist;
	public Integer getPagenumber() {
		return pagenumber;
	}
	public void setPagenumber(Integer pagenumber) {
		this.pagenumber = pagenumber;
	}
	public Integer getPagesize() {
		return pagesize;
	}
	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}
	public Long getTotalcount() {
		return totalcount;
	}
	public void setTotalcount(Long totalcount) {
		this.totalcount = totalcount;
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
	public List<AllergiesModel> getAllergieslist() {
		return allergieslist;
	}
	public void setAllergieslist(List<AllergiesModel> allergieslist) {
		this.allergieslist = allergieslist;
	}
	
	
}
