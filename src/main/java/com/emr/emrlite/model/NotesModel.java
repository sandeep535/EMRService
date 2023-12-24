package com.emr.emrlite.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="emr_notes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class NotesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long notesid;
    String description;
    Long visiid;
    Long clientid;
    Integer status;

}
