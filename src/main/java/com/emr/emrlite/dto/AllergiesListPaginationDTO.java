package com.emr.emrlite.dto;

import java.util.List;

import com.emr.emrlite.model.AllergiesMasterModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllergiesListPaginationDTO {
	
	Integer pagenumber;
	Integer pagesize;
	Long totalcount;
	List<AllergiesMasterModel> allergieslist;
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
	public List<AllergiesMasterModel> getAllergieslist() {
		return allergieslist;
	}
	public void setAllergieslist(List<AllergiesMasterModel> allergieslist) {
		this.allergieslist = allergieslist;
	}
	
	
}
