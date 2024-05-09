package com.mbpatil.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mbpatil.dto.paymentsDto.PaymentListDto;
import com.mbpatil.models.Payments;

public interface PaymentsRepository extends JpaRepository<Payments, Long> {

	 @Query("SELECT p FROM Payments p WHERE p.student.student_id = :student_id")
	 Payments byStudentId(Long student_id);

	 
	 @Query("SELECT new com.mbpatil.dto.paymentsDto.PaymentListDto(p.paymentId, p.totalFees, p.paidFees, p.courseName, p.student.student_id, CONCAT(p.student.firstName, COALESCE(CONCAT(' ', p.student.middleName), ''), COALESCE(CONCAT(' ', p.student.lastName), '')), p.student.mobileno,p.student.email) FROM Payments p")
	 List<PaymentListDto> allPayments();

	 
	 
}
