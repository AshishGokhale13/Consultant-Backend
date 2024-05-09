package com.mbpatil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mbpatil.dto.paymentsDto.PaymentListDto;
import com.mbpatil.dto.paymentsDto.PaymentsResponseDto;
import com.mbpatil.models.Payments;
import com.mbpatil.services.PaymentService;

@RestController
@RequestMapping({"/admin"})
public class PaymentController {

	@Autowired
	PaymentService paymentService;
	
	@GetMapping("/{id}")
	public PaymentsResponseDto getPayment(@PathVariable Long id)
	{
		return paymentService.getPayment(id);
	}
	
	@GetMapping("/bills")
	public List<PaymentListDto> getAllPayment()
	{
		return paymentService.getPayments();
	}
	
	@GetMapping("/bills/student/{id}")
	public PaymentsResponseDto getPaymentByStudentId(@PathVariable Long id)
	{
		return paymentService.getPaymentByStudentId(id);
	}
	
	
	
	@PutMapping("/bill/{id}")
	public PaymentsResponseDto updatePayment(@PathVariable Long id, @RequestBody Payments obj) {
	
		return paymentService.updatePayment(id,obj);
	}
	
	
}
