package com.mbpatil.dto.paymentsDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentListDto {

    int paymentId;
    Long totalFees;
    Long paidFees;
    String courseName;
    long student_id;
    String name;
    String mobileno;
    String email;
    
}

