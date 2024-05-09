package com.mbpatil.models;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Students {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long student_id;
	String firstName;
	String middleName;
	String lastName;
	String motherName; 
	Date dob;
	String cast;
	String category;
	String gender;
	Long adhar;
	String mobileno;
	String parentMobileno;
	String email;
	String address;
	String city;
	String district;
	String pincode;
	String password;
	String state;
	String country;
	String collegeName;
	String profile;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "enterance_id", referencedColumnName = "id")
	Enterance enterance;
	
	
}
