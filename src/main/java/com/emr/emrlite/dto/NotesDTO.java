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
    Long visitid;
    Long clientid;
    Integer status;
}
