package com.mbpatil.mapper;

import java.util.ArrayList;
import java.util.List;

import com.mbpatil.dto.paymentsDto.PaymentsDto;
import com.mbpatil.dto.paymentsDto.PaymentsResponseDto;
import com.mbpatil.models.Payments;
import com.mbpatil.models.Students;
import com.mbpatil.models.Transactions;

public class PaymentsMapper {

	public static Payments mapToEntity(Payments obj, Students sobj) {

		double remainingFees = obj.getTotalFees() - obj.getPaidFees();
		Transactions transactionObj = new Transactions();
		transactionObj.setTransactionAmount(obj.getPaidFees());
		transactionObj.setRemainingAmount(remainingFees);
		List<Transactions> ListTransObj=new ArrayList<>();
		ListTransObj.add(transactionObj);
		return new Payments(obj.getPaymentId(), obj.getTotalFees(), obj.getPaidFees(), obj.getCourseName(), sobj,
				ListTransObj,obj.getPaymentDate());
	}
	
	public static Payments mapToEntity(PaymentsDto obj) {
		
		return new Payments(obj.getPaymentId(), obj.getTotalFees(), obj.getPaidFees(), obj.getCourseName(),obj.getStudent(),obj.getTransactions(),obj.getPaymentDate());
	}
	
	public static PaymentsDto mapToDto(PaymentsDto obj) {
		
		return new PaymentsDto(obj.getPaymentId(), obj.getTotalFees(), obj.getPaidFees(), obj.getCourseName(),obj.getStudent(),obj.getTransactions(),obj.getPaymentDate());
	}
	
	public static PaymentsResponseDto mapToResponseDto(Payments obj) {
		
		return new PaymentsResponseDto(obj.getPaymentId(), obj.getTotalFees(), obj.getPaidFees(), obj.getCourseName(),obj.getStudent().getStudent_id(),obj.getTransactions(),obj.getPaymentDate());
	}
	
	public static PaymentsResponseDto mapDtoToResponseDto(PaymentsDto obj) {
		
		return new PaymentsResponseDto(obj.getPaymentId(), obj.getTotalFees(), obj.getPaidFees(), obj.getCourseName(),obj.getStudent().getStudent_id(),obj.getTransactions(),obj.getPaymentDate());
	}
}
