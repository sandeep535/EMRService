package com.emr.emrlite.dto;

import com.emr.emrlite.model.LookUpModel;
import com.emr.emrlite.model.MasterDataModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDTO {
    private Long id;
    private Integer empid;
    private String firstname;
    private String lastname;
    private String username;
    private LookUpModel title;
    private LookUpModel designation;
    private LookUpModel gender;
    private MasterDataModel role;
    private String token;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getEmpid() {
		return empid;
	}
	public void setEmpid(Integer empid) {
		this.empid = empid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public LookUpModel getTitle() {
		return title;
	}
	public void setTitle(LookUpModel title) {
		this.title = title;
	}
	public LookUpModel getDesignation() {
		return designation;
	}
	public void setDesignation(LookUpModel designation) {
		this.designation = designation;
	}
	public LookUpModel getGender() {
		return gender;
	}
	public void setGender(LookUpModel gender) {
		this.gender = gender;
	}
	public MasterDataModel getRole() {
		return role;
	}
	public void setRole(MasterDataModel role) {
		this.role = role;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
    
    
}
