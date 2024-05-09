package com.mbpatil.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Enterance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String gradeType;
	String applicationNumber;
	String rollNo;
	int year;
	double marks;
	
	
	
	}
