package com.mbpatil.mapper;

import com.mbpatil.dto.admin.AdminDto;
import com.mbpatil.models.Admin;

public class AdminMapper {
	
	
	public static Admin mapTOEntity(AdminDto obj)
	{
		return new Admin(obj.getId(),obj.getUsername(),obj.getPassword());
	}
	
	public static AdminDto mapTODto(Admin obj)
	{
		return new AdminDto(obj.getId(),obj.getUsername(),obj.getPassword());
	}
	
	
}
