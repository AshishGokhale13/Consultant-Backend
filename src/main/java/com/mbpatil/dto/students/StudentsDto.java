package com.mbpatil.dto.students;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import com.mbpatil.annotations.IsValid;
import com.mbpatil.dto.enterance.EnteranceDto;
import com.mbpatil.models.Payments;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter 
public class StudentsDto {

	Long student_id;
	
	
	@NotEmpty(message = "First name should not be Empty")
	String firstName;
	
	@NotEmpty (message = "Middle name should not be Empty")
	String middleName;
	
	@NotEmpty (message = "Last name should not be Empty")
	String lastName;
	
	@NotEmpty (message = "Mother's name should not be Empty")
	String motherName; 
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date dob;
	
	@NotEmpty(message = "Cast value should not be empty")
	String cast;
	
	@NotEmpty(message = "Category value should not be empty")
	String category;
	
	@NotNull(message="Gender value should not be null")
	String gender;
	
	
//	@Digits(integer = 12,fraction = 0,message = "Adhar No should be in number format")
	//@Size(min=12,max=12, message="Adhar no should be 12 digit long")
	@IsValid(type = Long.class,minLength = 12,maxLength = 12, message = "Adhar No. should be valid 12 digit number")
	Long adhar;
	
	@IsValid(type = String.class,minLength = 10,maxLength =10, message =  "Mobile No. should be valid 10 digit number")
	String mobileno;
	
	@IsValid(type = String.class,minLength = 10,maxLength =10, message =  "Mobile No. should be valid 10 digit number")
	String parentMobileno;
	
	@Email(message="please mention proper email id")
	String email;
	
	@NotEmpty(message = "Address value should not be empty")
	String address;
	
	@NotEmpty(message="Pincode should not be empty")
	String city;
	
	@NotEmpty(message="District should not be null")
	String district;
	
	@NotEmpty(message="Pincode should not be empty")
	String pincode;
	
	@NotEmpty(message="Pincode should not be empty")
	String password;
	
	
	@NotEmpty(message = "State should not be empty")
	String state;
	
	@NotEmpty(message = "Country should not be empty")
	String country;
	
	@NotEmpty(message = "College Name should not be empty")
	String collegeName;
	
	@NotNull
	MultipartFile profile;
	
	
	@NotNull
	EnteranceDto enterance;
	
	@NotNull
	Payments payment;

	
	
	
	
	public StudentsDto(Long student_id, @NotEmpty(message = "First name should not be Empty") String firstName,
			@NotEmpty(message = "Middle name should not be Empty") String middleName,
			@NotEmpty(message = "Last name should not be Empty") String lastName,
			@NotEmpty(message = "Mother's name should not be Empty") String motherName, Date dob,
			@NotEmpty(message = "Cast value should not be empty") String cast,
			@NotEmpty(message = "Category value should not be empty") String category,
			@NotNull(message = "Gender value should not be null") String gender, Long adhar, String mobileno,
			String parentMobileno, @Email(message = "please mention proper email id") String email,
			@NotEmpty(message = "Address value should not be empty") String address,
			@NotEmpty(message = "Address value should not be empty") String city,
			@NotEmpty(message = "District should not be null") String district,
			@NotEmpty(message = "Pincode should not be empty") String pincode,
			@NotEmpty(message = "Pincode should not be empty") String password,
			@NotEmpty(message = "State should not be empty") String state,
			@NotEmpty(message = "Country should not be empty") String country,
			@NotEmpty(message = "College Name should not be empty") String collegeName,
			@NotNull EnteranceDto enterance) {
		super();
		this.student_id = student_id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.motherName = motherName;
		this.dob = dob;
		this.cast = cast;
		this.category = category;
		this.gender = gender;
		this.adhar = adhar;
		this.mobileno = mobileno;
		this.parentMobileno = parentMobileno;
		this.email = email;
		this.address = address;
		this.address=city;
		this.district = district;
		this.pincode = pincode;
		this.password=password;
		this.state = state;
		this.country = country;
		this.collegeName = collegeName;
		this.enterance=enterance;
	}
	
	
	
	
}
