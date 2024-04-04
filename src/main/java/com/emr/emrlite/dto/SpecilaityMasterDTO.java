package com.emr.emrlite.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpecilaityMasterDTO {
    private Long specilaityid;
    private String specilaityname;
    private Integer status;
	public Long getSpecilaityid() {
		return specilaityid;
	}
	public void setSpecilaityid(Long specilaityid) {
		this.specilaityid = specilaityid;
	}
	public String getSpecilaityname() {
		return specilaityname;
	}
	public void setSpecilaityname(String specilaityname) {
		this.specilaityname = specilaityname;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
    
    
}
