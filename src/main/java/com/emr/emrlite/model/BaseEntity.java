package com.emr.emrlite.model;

import com.emr.emrlite.utils.ExecutionContext;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.type.descriptor.DateTimeUtils;

import java.util.Calendar;
import java.util.Date;

@MappedSuperclass
@EntityListeners({})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_ON", nullable = false, updatable = false)
    private Date createdDate;

    @Column(name = "CREATED_BY", nullable = false, updatable = false)
    private Long createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EDITED_ON", nullable = false)
    private Date editedDate;

    @Column(name = "EDITED_BY", nullable = false)
    private Long editedBy;
    @PrePersist
    protected void onPrePersist() {
        ExecutionContext context = new ExecutionContext();
       setCreatedBy(context.getEmployee().getId());
       Calendar cal = Calendar.getInstance();
       setCreatedDate(cal.getTime());
        setEditedBy(context.getEmployee().getId());
        setCreatedDate(cal.getTime());
    }

    @PreUpdate
    protected void onPreUpdate() {
        ExecutionContext context = new ExecutionContext();
        setEditedBy(context.getEmployee().getId());
        Calendar cal = Calendar.getInstance();
        setCreatedDate(cal.getTime());
    }
}
