package com.emr.emrlite.dto;

import java.util.List;

import com.emr.emrlite.model.DiagnosisMasterModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiagnosisMasterPaginationDTO {
	Integer pagenumber;
	Integer pagesize;
	Long totalcount;
	List<DiagnosisMasterModel> diagnosisMasterModel;
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
	public List<DiagnosisMasterModel> getDiagnosisMasterModel() {
		return diagnosisMasterModel;
	}
	public void setDiagnosisMasterModel(List<DiagnosisMasterModel> diagnosisMasterModel) {
		this.diagnosisMasterModel = diagnosisMasterModel;
	}
	
	
}
