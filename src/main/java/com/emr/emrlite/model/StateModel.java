package com.emr.emrlite.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="states")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StateModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long stateid;
    private String statename;
    private String statecode;
    private Long countryid;
    private Integer status;
	public Long getStateid() {
		return stateid;
	}
	public void setStateid(Long stateid) {
		this.stateid = stateid;
	}
	public String getStatename() {
		return statename;
	}
	public void setStatename(String statename) {
		this.statename = statename;
	}
	public String getStatecode() {
		return statecode;
	}
	public void setStatecode(String statecode) {
		this.statecode = statecode;
	}
	public Long getCountryid() {
		return countryid;
	}
	public void setCountryid(Long countryid) {
		this.countryid = countryid;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
    
    
}
