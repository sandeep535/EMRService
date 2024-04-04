package com.emr.emrlite.dto;


import com.emr.emrlite.model.LookUpModel;
import com.emr.emrlite.model.MasterDataModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private Long id;
    private Integer empid;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private LookUpModel title;
    private LookUpModel designation;
    private LookUpModel gender;
    private MasterDataModel role;
    private Integer age;
    private Date dob;
    private String mail;
    private String mobilenumber;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
    
    
}
