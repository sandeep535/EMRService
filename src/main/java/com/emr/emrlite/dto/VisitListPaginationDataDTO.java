package com.emr.emrlite.dto;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisitListPaginationDataDTO {
	
	
	Integer pagenumber;
	Integer pagesize;
	Long totalcount;
	List<VisitDetailsDTO> visitDetailsDTO;
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
	public List<VisitDetailsDTO> getVisitDetailsDTO() {
		return visitDetailsDTO;
	}
	public void setVisitDetailsDTO(List<VisitDetailsDTO> visitDetailsDTO) {
		this.visitDetailsDTO = visitDetailsDTO;
	}
	
	
	
}
