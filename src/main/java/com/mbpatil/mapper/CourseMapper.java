package com.mbpatil.mapper;

import com.mbpatil.dto.courses.CourseseEntityDto;
import com.mbpatil.models.Courses;

public class CourseMapper {

	
	public static Courses mapToEntity(CourseseEntityDto obj)
	{
		return new Courses(obj.getCourses_id(),obj.getCourse_name(),obj.getFeesAmount());
	}
	

	public static CourseseEntityDto mapToDto(Courses obj)
	{
		return new CourseseEntityDto(obj.getCourses_id(),obj.getCourse_name(),obj.getFeesAmount());
	}
	
}
