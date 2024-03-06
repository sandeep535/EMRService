package com.emr.emrlite.repository;

import com.emr.emrlite.model.RoleTaksActionsModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleTaksActionsRepository extends JpaRepository<RoleTaksActionsModel,Long> {

    List<RoleTaksActionsModel> findRoleTaksActionsModelByRoleid(Long roleid);
}
