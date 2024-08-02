package com.emr.emrlite.dto;

import java.util.List;

import com.emr.emrlite.model.LabMasterModel;

public class LabMasterPaginationDTO {
	Integer pagenumber;
	Integer pagesize;
	Long totalcount;
	List<LabMasterModel> labMasterModel;
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
	public List<LabMasterModel> getLabMasterModel() {
		return labMasterModel;
	}
	public void setLabMasterModel(List<LabMasterModel> labMasterModel) {
		this.labMasterModel = labMasterModel;
	}
	
	
}
