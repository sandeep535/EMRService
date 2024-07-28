package com.emr.emrlite.dto;

import com.emr.emrlite.model.LookUpModel;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiagnosisMasterDTO {
	
    private Long dignosisid;
    private String dignosisname;
    private String dignosiscode;
    private Integer status;
    private LookUpModel dignosiscodeset;
	public Long getDignosisid() {
		return dignosisid;
	}
	public void setDignosisid(Long dignosisid) {
		this.dignosisid = dignosisid;
	}
	public String getDignosisname() {
		return dignosisname;
	}
	public void setDignosisname(String dignosisname) {
		this.dignosisname = dignosisname;
	}
	public String getDignosiscode() {
		return dignosiscode;
	}
	public void setDignosiscode(String dignosiscode) {
		this.dignosiscode = dignosiscode;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public LookUpModel getDignosiscodeset() {
		return dignosiscodeset;
	}
	public void setDignosiscodeset(LookUpModel dignosiscodeset) {
		this.dignosiscodeset = dignosiscodeset;
	}
    
    
}
