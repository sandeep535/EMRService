package com.emr.emrlite.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotesDTO {
    Long notesid;
    String description;
    Long visiid;
    Long clientid;
    Integer status;
}
