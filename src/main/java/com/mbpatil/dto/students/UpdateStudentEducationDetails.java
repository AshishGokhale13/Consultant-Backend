package com.mbpatil.dto.students;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateStudentEducationDetails {

	String collegeName;
	String gradeType;
	String applicationNumber;
	String rollNo;
	int year;
	double marks;

}
