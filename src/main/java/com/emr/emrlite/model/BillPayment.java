package com.emr.emrlite.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BILL_PAYMENT")
public class BillPayment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PAYMENT_ID")
    private Long paymentId;

    @ManyToOne
    @JoinColumn(name = "BILL_ID", nullable = false)
    private BillModel bill;

    @Column(name = "PAYMENT_DATE")
    private Date paymentDate;

    @Column(name = "PAYMENT_AMOUNT")
    private Double paymentAmount;

    @Column(name = "PAYMENT_MODE")
    private String paymentMode; // e.g., Cash, Card, UPI, etc.

    @Column(name = "REMARKS")
    private String remarks;

    // Getters and setters
}
