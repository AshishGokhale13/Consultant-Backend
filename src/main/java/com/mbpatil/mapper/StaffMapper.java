package com.mbpatil.mapper;

import com.mbpatil.dto.staff.StaffDto;
import com.mbpatil.models.Staff;

public class StaffMapper {

	public static Staff mapToEntity(StaffDto obj)
	{
		return new Staff(obj.getStaffId(), obj.getName(), obj.getMobile(), obj.getEmail(), obj.getDob(), obj.getAdharNo(), obj.getPanNo(), obj.getProfilePath(), obj.getGender());
	}
	
	public static StaffDto mapToDto(Staff obj)
	{
		return new StaffDto(obj.getStaffId(), obj.getName(), obj.getMobile(), obj.getEmail(), obj.getDob(), obj.getAdharNo(), obj.getPanNo(), obj.getProfilePath(), obj.getGender());
	}	
}
