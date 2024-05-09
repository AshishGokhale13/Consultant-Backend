package com.mbpatil.mapper;

import com.mbpatil.dto.enterance.EnteranceDto;
import com.mbpatil.models.Enterance;

public class EnteranceMapper {

	public static Enterance mapToEntity(EnteranceDto obj)
	{
		return new Enterance(obj.getId(),obj.getGradeType(),obj.getApplicationNumber(),obj.getRollNo(),obj.getYear(),obj.getMarks());
	}
	
	public static EnteranceDto mapToDto(Enterance obj)
	{
		return new EnteranceDto(obj.getId(),obj.getGradeType(),obj.getApplicationNumber(),obj.getRollNo(),obj.getYear(),obj.getMarks());
	}
}
