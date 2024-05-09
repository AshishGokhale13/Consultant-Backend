package com.mbpatil.dto.staff;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateStaffDto {

	String name;
	Long mobile;
	String email;
	Date dob;
	Long adharNo;
	String panNo;
	String gender;
	
}
