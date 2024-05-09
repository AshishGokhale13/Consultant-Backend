package com.mbpatil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mbpatil.dto.staff.StaffDto;
import com.mbpatil.dto.staff.UpdateStaffDto;
import com.mbpatil.models.Staff;
import com.mbpatil.services.StaffServices;

@RestController 
@RequestMapping({"/","/admin"})
public class StaffController {

	@Autowired
	StaffServices staffService;
	
	@PostMapping("/saveStaff")
	public Staff newStaff(@ModelAttribute StaffDto obj)
	{
		return staffService.saveStaff(obj);
	}
	
	
	@GetMapping("/staffList")
	public List<Staff> getStaff() {
		return staffService.getStaffList();
	}
	

	@GetMapping("/staff/{id}")
	public Staff getStaff(@PathVariable Long id) {
		return staffService.getStaff(id);
	}
	
	
	@PutMapping("/updateStaff/{id}")
	public Staff updateStaff(@PathVariable Long id,@RequestBody UpdateStaffDto obj)
	{
		return staffService.updateStaff(id, obj);
	}
	
	
	@DeleteMapping("staff/{id}")
	public boolean deleteStudent(@PathVariable Long id){
		return staffService.deleteStaff(id);
	}
	
}
