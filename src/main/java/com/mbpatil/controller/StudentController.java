package com.mbpatil.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mbpatil.dto.students.StudentsDto;
import com.mbpatil.dto.students.StudentsEntityDto;
import com.mbpatil.dto.students.UpdateStudentEducationDetails;
import com.mbpatil.dto.students.UpdateStudentPersonalDetailsDto;
import com.mbpatil.dto.students.UpdateStudentProfileDto;
import com.mbpatil.models.Students;
import com.mbpatil.services.StudentServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping({"/admin","/student"})
public class StudentController {

	StudentServices studService;
	
		

	public StudentController(StudentServices studService) {
		super();
		this.studService = studService;
	
	}

	@PostMapping("/register")
	public Object register(@Valid @ModelAttribute StudentsDto obj) {
		
		
		 StudentsEntityDto SED= studService.saveStudent(obj);
		return SED;
	}
	
	@GetMapping("/students")
	public List<Students> getStudents(@ModelAttribute StudentsDto obj) {
		
		return studService.getAllStudents();
	}

	

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) {
		BindingResult result = ex.getBindingResult();
		Map<String, String> errors = new HashMap<>();
		for (FieldError error : result.getFieldErrors()) {
			errors.put(error.getField(), error.getDefaultMessage());
		}
		return ResponseEntity.badRequest().body(errors);
	}
	
	
	@GetMapping("/studentsList")
	public List<Students> getStudents() {	
		return studService.getAllStudents();
	}
	
	
	@GetMapping("/studentInfo/{id}")
	public Students getStaff(@PathVariable Long id) {
		
		return studService.getStudent(id);
				
	}
	
	@PutMapping("updateStudent/{id}")
	public Students updateStudent(@PathVariable Long id,@RequestBody UpdateStudentProfileDto obj) {
		return studService.updateStudentProfile(id, obj);		
	}
	
	@PutMapping("updateStudentPersonalInfo/{id}")
	public Students updateStudentPersonalInfo(@PathVariable Long id,@RequestBody UpdateStudentPersonalDetailsDto obj) {
		return studService.updateStudentPersonalDetails(id, obj);			
	}
	
	@PutMapping("updateStudentEducationalInfo/{id}")
	public Students updateStudentEducationalInfo(@PathVariable Long id,@RequestBody UpdateStudentEducationDetails obj) {
		
		return studService.updateStudentEducationalDetails(id, obj);
				
	}
	
	
	@DeleteMapping("student/{id}")
	public boolean deleteStudent(@PathVariable Long id){
		return studService.deleteStudent(id);
	}
	
	
	
	
}
