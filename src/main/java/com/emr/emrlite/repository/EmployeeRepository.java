package com.emr.emrlite.repository;

import com.emr.emrlite.model.EmployeeModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeModel,Long> {
    @Query("SELECT u FROM EmployeeModel u WHERE u.firstname like %:employeeName%")
    List<EmployeeModel> getEmployeesBasedOnName(String employeeName);

    List<EmployeeModel> findAllByUsername(String username,Pageable pageRequest);
    @Query("SELECT u FROM EmployeeModel u")
    List<EmployeeModel> findAllEmp(Pageable pageRequest);

    EmployeeModel findEmployeeModelByUsername(String username);
}
