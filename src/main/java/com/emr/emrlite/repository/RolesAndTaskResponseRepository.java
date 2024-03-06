package com.emr.emrlite.repository;

import com.emr.emrlite.dto.RolesAndTaskResponseDTO;
import com.emr.emrlite.model.RolesAndTaskResponseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

@EnableJpaRepositories
public interface RolesAndTaskResponseRepository extends JpaRepository<RolesAndTaskResponseModel,Long> {
    @Procedure(name = "GET_ROLES_TASKS_BASED_ON_ROLE")
    List<RolesAndTaskResponseModel> GET_ROLES_TASKS_BASED_ON_ROLE(@Param("roleid") Long roleid);
}
