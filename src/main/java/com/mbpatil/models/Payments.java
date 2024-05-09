package com.mbpatil.models;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Payments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int paymentId;	
	Long totalFees;
	Long paidFees;
	String courseName;	
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JoinColumn(name = "student_id", referencedColumnName = "student_id", nullable = false)
	Students student;
	
	@OneToMany(cascade = CascadeType.REMOVE)
	@JoinColumn(name="payment_id")
	List<Transactions> transactions;
	
	Date paymentDate;
	
	 @PrePersist
	    protected void onCreate() {
		 paymentDate = new Date();
	    }
	
}
