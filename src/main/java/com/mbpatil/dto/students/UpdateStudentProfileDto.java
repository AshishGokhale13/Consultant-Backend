package com.mbpatil.dto.students;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStudentProfileDto {

	String firstName;
	String middleName;
	String lastName;
	
	String email;
	String mobileno;
	String gender;
	Date dob;
	Long adhar;
}
