package com.mbpatil.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Transactions {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	double transactionAmount;
	double remainingAmount;
	Date transactionDate;
	
	 @PrePersist
	    protected void onCreate() {
		 transactionDate = new Date();
	    }
}
