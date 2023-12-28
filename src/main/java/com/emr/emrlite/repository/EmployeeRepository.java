package com.emr.emrlite.repository;

import com.emr.emrlite.dto.EmployeeDTO;
import com.emr.emrlite.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeModel,Long> {
    @Query("SELECT u FROM EmployeeModel u WHERE u.firstname like %:employeeName%")
    List<EmployeeModel> getEmployeesBasedOnName(String employeeName);

    EmployeeModel findEmployeeModelByUsername(String username);
}
