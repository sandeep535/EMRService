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
    @Column(name = "CREATED_ON")
    private Date createdDate;

    @Column(name = "CREATED_BY")
    private Long createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EDITED_ON")
    private Date editedDate;

    @Column(name = "EDITED_BY")
    private Long editedBy;
    
    
    
    public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getEditedDate() {
		return editedDate;
	}

	public void setEditedDate(Date editedDate) {
		this.editedDate = editedDate;
	}

	public Long getEditedBy() {
		return editedBy;
	}

	public void setEditedBy(Long editedBy) {
		this.editedBy = editedBy;
	}

	@PrePersist
    protected void onPrePersist() {
        ExecutionContext context = new ExecutionContext();
       // context.em
        setCreatedBy(1l);
        setEditedBy(1l);
        Calendar cal = Calendar.getInstance();
        setCreatedDate(cal.getTime());
     //   setEditedBy(context.getEmployee().getId());
        setCreatedDate(cal.getTime());
    }

    @PreUpdate
    protected void onPreUpdate() {
      //  ExecutionContext context = new ExecutionContext();
        setEditedBy(1l);
        Calendar cal = Calendar.getInstance();
        setCreatedDate(cal.getTime());
    }
}
