package com.emr.emrlite.utils;

import com.emr.emrlite.dto.EmployeeDTO;
import com.emr.emrlite.model.EmployeeModel;
import lombok.Getter;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Getter
@XmlRootElement(name = "ExecutionContext")
public class ExecutionContext implements Serializable {
    private EmployeeModel employee;

    public void setEmploye(EmployeeModel employee) {
        this.employee = employee;
    }
    public EmployeeModel getEmploye() {
        return  this.employee;
    }
}
