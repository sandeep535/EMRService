package com.emr.emrlite.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import com.emr.emrlite.model.MasterDataModel;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillPaymentDTO {
    private Long billId;
    private Date paymentDate;
    private Double paymentAmount;
    private Long paymentMode;
    private String remarks;
}
