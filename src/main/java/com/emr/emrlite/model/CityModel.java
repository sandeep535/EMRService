package com.emr.emrlite.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="cities")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CityModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long cityid;
    String cityname;
    String citycode;
    Long stateid;
    Integer status;
	public Long getCityid() {
		return cityid;
	}
	public void setCityid(Long cityid) {
		this.cityid = cityid;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	public Long getStateid() {
		return stateid;
	}
	public void setStateid(Long stateid) {
		this.stateid = stateid;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
    
    
}
