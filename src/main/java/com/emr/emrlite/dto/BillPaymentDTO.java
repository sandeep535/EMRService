package com.emr.emrlite.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillPaymentDTO {
    private Long billId;
    private Date paymentDate;
    private Double paymentAmount;
    private String paymentMode;
    private String remarks;
}
