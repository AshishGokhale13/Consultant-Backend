package com.mbpatil.dto.paymentsDto;

import java.util.Date;
import java.util.List;

import com.mbpatil.models.Transactions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentsResponseDto {
	int paymentId;	
	Long totalFees;
	Long paidFees;
	String courseName;	
	Long student_id;
	List<Transactions> transactions;
	Date paymentDate;
}
