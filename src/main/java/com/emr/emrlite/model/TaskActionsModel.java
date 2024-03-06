package com.emr.emrlite.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="taskactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskActionsModel extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long taskid;
    private String screencode;
    private String screenname;
    private String actionname;
    private String actioncode;
    private Integer status;
}
