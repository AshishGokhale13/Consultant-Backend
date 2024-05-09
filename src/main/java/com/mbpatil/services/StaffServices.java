package com.mbpatil.services;

import java.util.List;

import com.mbpatil.dto.staff.StaffDto;
import com.mbpatil.dto.staff.UpdateStaffDto;
import com.mbpatil.models.Staff;

public interface StaffServices {

	String staffProfilePath="E:/stsproject/mbpatil/src/main/resources/static/images/staff/";
	
	Staff saveStaff(StaffDto obj);
	List<Staff> getStaffList();
	Staff getStaff(Long id);
	Staff updateStaff(Long id,UpdateStaffDto obj);
	boolean deleteStaff(Long id);
}
