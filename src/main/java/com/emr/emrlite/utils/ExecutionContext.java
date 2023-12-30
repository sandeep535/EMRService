package com.emr.emrlite.utils;

import com.emr.emrlite.dto.EmployeeDTO;
import com.emr.emrlite.model.EmployeeModel;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "ExecutionContext")
public class ExecutionContext implements Serializable {
    private EmployeeModel employee;
    public EmployeeModel getEmployee() {
        return employee;
    }

    public void setEmploye(EmployeeModel employee) {
        this.employee = employee;
    }
}
