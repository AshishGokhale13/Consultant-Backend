package com.mbpatil.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbpatil.Repository.CoursesRepository;
import com.mbpatil.dto.courses.CourseseEntityDto;
import com.mbpatil.mapper.CourseMapper;
import com.mbpatil.models.Courses;
import com.mbpatil.services.CoursesService;

@Service
public class CoursesServiceImpl implements CoursesService {

	@Autowired
	CoursesRepository courseRepo;
	
	@Override
	public CourseseEntityDto addCourse(CourseseEntityDto obj) {
		
		return CourseMapper.mapToDto(courseRepo.save(CourseMapper.mapToEntity(obj)));
	}

	
	@Override
	public List<CourseseEntityDto> fetchCourses() {		
		return courseRepo.findAll().stream().map(t->CourseMapper.mapToDto(t)).collect(Collectors.toList());
	}


	public CourseseEntityDto updateCourse(Long id, CourseseEntityDto obj) {
		Courses courseObj=courseRepo.findById(id).orElse(null);
		if (courseObj!=null)
		{
			courseObj.setCourse_name(obj.getCourse_name());
			courseObj.setFeesAmount(obj.getFeesAmount());
			courseObj=courseRepo.save(courseObj);
			if(courseObj!=null)
				return CourseMapper.mapToDto(courseObj);
		}
		return null;
	}


	@Override
	public boolean deleteCourse(Long id) {
	   
		Courses courseObj= courseRepo.findById(id).orElse(null);
	   if(courseObj!=null)
		{
			courseRepo.delete(courseObj);
			return true;
		}
	   return false;
	}
	
	
}
