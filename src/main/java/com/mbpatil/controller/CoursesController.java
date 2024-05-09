package com.mbpatil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mbpatil.dto.courses.CourseseEntityDto;
import com.mbpatil.services.CoursesService;

@RestController
@RequestMapping("/admin")
public class CoursesController {

	@Autowired
	CoursesService courseService;

	
	@GetMapping("/courses")
	public List<CourseseEntityDto> addCourse()
	{
		return courseService.fetchCourses();
	}
	
	
	@PostMapping("/course")
	public CourseseEntityDto addCourse(@RequestBody CourseseEntityDto obj)
	{
		return courseService.addCourse(obj);
	}
	
	
	@PutMapping("/course/{id}")
	public CourseseEntityDto updateCourse(@PathVariable Long id, @RequestBody CourseseEntityDto obj)
	{
		return courseService.addCourse(obj);
	}
	
	
	@DeleteMapping("/course/{id}")
	public boolean removeCourse(@PathVariable Long id)
	{
		return courseService.deleteCourse(id);
	}
	
}
