package com.emr.emrlite.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="specilaity_master")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SpecilaityMasterModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
