package com.emr.emrlite.repository;


import com.emr.emrlite.model.NotesModel;
import com.emr.emrlite.model.VitalsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NotesRepository extends JpaRepository<NotesModel,Long> {
    @Query("SELECT u FROM NotesModel u WHERE u.visitid = :visitid")
    NotesModel getNotes(Long visitid);
}
