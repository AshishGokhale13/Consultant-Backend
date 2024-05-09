package com.mbpatil.services;

import java.util.List;

import com.mbpatil.dto.courses.CourseseEntityDto;

public interface CoursesService {
	
	CourseseEntityDto addCourse(CourseseEntityDto obj);
	List<CourseseEntityDto> fetchCourses();
	CourseseEntityDto updateCourse(Long id,CourseseEntityDto obj);
	boolean deleteCourse(Long id);
	
}
