package com.mbpatil.dto.paymentsDto;

import java.util.Date;
import java.util.List;

import com.mbpatil.models.Students;
import com.mbpatil.models.Transactions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaymentsDto {

	int paymentId;	
	Long totalFees;
	Long paidFees;
	String courseName;	
	Students student;
	List<Transactions> transactions;
	Date paymentDate;
}
