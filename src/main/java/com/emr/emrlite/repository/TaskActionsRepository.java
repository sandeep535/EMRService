package com.emr.emrlite.repository;


import com.emr.emrlite.dto.RolesAndTaskResponseDTO;
import com.emr.emrlite.model.RolesAndTaskResponseModel;
import com.emr.emrlite.model.TaskActionsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskActionsRepository extends JpaRepository<TaskActionsModel,Long> {


    //@Query(value = "CALL GET_ROLES_TASKS_BASED_ON_ROLE(:roleid)", nativeQuery = true)
    @Procedure(name = "GET_ROLES_TASKS_BASED_ON_ROLE")
    List<RolesAndTaskResponseModel> GET_ROLES_TASKS_BASED_ON_ROLE(@Param("roleid") Long roleid);
}
