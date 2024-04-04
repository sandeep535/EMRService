package com.emr.emrlite.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotesDTO {
    Long notesid;
    String description;
    Long visitid;
    Long clientid;
    Integer status;
	public Long getNotesid() {
		return notesid;
	}
	public void setNotesid(Long notesid) {
		this.notesid = notesid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
    
    
}
