package com.emr.emrlite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emr.emrlite.model.DataSourceConfig;

public interface DataSourceConfigRepository extends JpaRepository<DataSourceConfig, Long> {
	DataSourceConfig findByName(String name);
}