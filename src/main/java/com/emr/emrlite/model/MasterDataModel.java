package com.emr.emrlite.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="masterdata")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MasterDataModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String mastercode;
    private String masterdatavalue;
    private Integer active;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMastercode() {
		return mastercode;
	}
	public void setMastercode(String mastercode) {
		this.mastercode = mastercode;
	}
	public String getMasterdatavalue() {
		return masterdatavalue;
	}
	public void setMasterdatavalue(String masterdatavalue) {
		this.masterdatavalue = masterdatavalue;
	}
	public Integer getActive() {
		return active;
	}
	public void setActive(Integer active) {
		this.active = active;
	}
    
    

}
