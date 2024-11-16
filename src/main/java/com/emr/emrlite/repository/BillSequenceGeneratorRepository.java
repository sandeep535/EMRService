package com.emr.emrlite.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emr.emrlite.model.BillSequenceGenerator;

public interface BillSequenceGeneratorRepository extends JpaRepository<BillSequenceGenerator, Long> {
	
	//Optional<BillSequenceGenerator> findById(Long id);	

}
