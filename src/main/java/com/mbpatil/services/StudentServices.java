package com.mbpatil.services;

import java.util.List;

import com.mbpatil.dto.students.StudentsDto;
import com.mbpatil.dto.students.StudentsEntityDto;
import com.mbpatil.dto.students.UpdateStudentEducationDetails;
import com.mbpatil.dto.students.UpdateStudentPersonalDetailsDto;
import com.mbpatil.dto.students.UpdateStudentProfileDto;
import com.mbpatil.models.Students;

public interface StudentServices {

	String studentProfilePath = "E:/stsproject/mbpatil/src/main/resources/static/images/students/";

	StudentsEntityDto saveStudent(StudentsDto obj);

	List<Students> getAllStudents();

	Students getStudent(Long id);

	Students updateStudentProfile(Long id, UpdateStudentProfileDto obj);
	
	Students updateStudentPersonalDetails(Long id, UpdateStudentPersonalDetailsDto obj);
	Students updateStudentEducationalDetails(Long id, UpdateStudentEducationDetails obj);
	
	boolean deleteStudent(Long id);


}
