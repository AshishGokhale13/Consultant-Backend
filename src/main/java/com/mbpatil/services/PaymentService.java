package com.mbpatil.services;

import java.util.List;

import com.mbpatil.dto.paymentsDto.PaymentListDto;
import com.mbpatil.dto.paymentsDto.PaymentsResponseDto;
import com.mbpatil.models.Payments;


public interface PaymentService {

	PaymentsResponseDto getPayment(Long id);
	PaymentsResponseDto getPaymentByStudentId(Long id);
	PaymentsResponseDto updatePayment(Long id,Payments obj);
	List<PaymentListDto> getPayments();
	
}
