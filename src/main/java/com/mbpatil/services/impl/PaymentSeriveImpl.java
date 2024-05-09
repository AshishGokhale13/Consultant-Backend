package com.mbpatil.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbpatil.Repository.PaymentsRepository;
import com.mbpatil.Repository.TransactionsRepository;
import com.mbpatil.dto.paymentsDto.PaymentListDto;
import com.mbpatil.dto.paymentsDto.PaymentsResponseDto;
import com.mbpatil.mapper.PaymentsMapper;
import com.mbpatil.models.Payments;
import com.mbpatil.models.Transactions;
import com.mbpatil.services.PaymentService;

@Service
public class PaymentSeriveImpl implements PaymentService {

	
	@Autowired
	PaymentsRepository paymentRepo;
	
	@Autowired
	TransactionsRepository transRepo;  
	
	@Override
	public PaymentsResponseDto getPayment(Long id) {
		
		return PaymentsMapper.mapToResponseDto(paymentRepo.findById(id).orElse(null));
	}

	@Override
	public PaymentsResponseDto getPaymentByStudentId(Long id) {
		
		return PaymentsMapper.mapToResponseDto(paymentRepo.byStudentId(id));
	}

	@Override
	public List<PaymentListDto> getPayments() {
		// TODO Auto-generated method stub
		return paymentRepo.allPayments();
	}

	@Override
	public PaymentsResponseDto updatePayment(Long id, Payments obj) {
		
		Payments paymentObj=paymentRepo.findById(id).orElse(null);
		if(paymentObj!=null)
		{
			paymentObj.setCourseName(obj.getCourseName());
			paymentObj.setPaidFees(obj.getPaidFees());
			paymentObj.setTotalFees(obj.getTotalFees());
			
			Transactions transObj=new Transactions(null, obj.getTransactions().get(0).getTransactionAmount(),obj.getTransactions().get(0).getRemainingAmount(), null);
			transObj =transRepo.save(transObj);
			
			if(transObj!=null)
			{
			
			paymentObj.getTransactions().add(transObj);
			paymentObj=paymentRepo.save(paymentObj);
			
			if(paymentObj!=null)
				return PaymentsMapper.mapToResponseDto(paymentObj);
			return null;
			
			}return null;
		}
		
		// TODO Auto-generated method stub
		return null;
	}
		
}
