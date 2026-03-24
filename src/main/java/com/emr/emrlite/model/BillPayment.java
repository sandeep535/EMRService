package com.emr.emrlite.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "BILL_ID", nullable = false)
    private BillModel bill;

    @Column(name = "PAYMENT_DATE")
    private Date paymentDate;

    @Column(name = "PAYMENT_AMOUNT")
    private Double paymentAmount;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "PAYMENT_MODE", referencedColumnName = "id")
    private MasterDataModel paymentMode;
    
    @Column(name = "TRANSACTION_NUMBER")
    private String transactionNumber;

    @Column(name = "REMARKS")
    private String remarks;
    
   

    // Getters and setters
}
