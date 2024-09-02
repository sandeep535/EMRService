package com.emr.emrlite.repositoryImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.emr.emrlite.model.AllergiesFavouriteModel;
import com.emr.emrlite.repository.AllergiesFavarateReposiroty;

import jakarta.persistence.EntityManager;

@Repository
public class AllergiesFavarateReposirotyImpl implements AllergiesFavarateReposiroty {

	@Autowired
    EntityManager entityManager;

	
	@Override
	public Boolean saveAllergiesFavourite(List<AllergiesFavouriteModel> allergiesFavouriteModel) {
		 entityManager.merge(allergiesFavouriteModel);
	     return true;
	}

}
