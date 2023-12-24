package com.emr.emrlite.repository;


import com.emr.emrlite.model.NotesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRepository extends JpaRepository<NotesModel,Long> {

}
