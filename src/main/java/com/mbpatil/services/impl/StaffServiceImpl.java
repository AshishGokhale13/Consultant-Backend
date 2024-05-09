package com.mbpatil.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbpatil.Repository.StaffRepository;
import com.mbpatil.customeOps.CustomOperations;
import com.mbpatil.dto.staff.StaffDto;
import com.mbpatil.dto.staff.UpdateStaffDto;
import com.mbpatil.mapper.StaffMapper;
import com.mbpatil.models.Staff;
import com.mbpatil.services.StaffServices;

@Service
public class StaffServiceImpl implements StaffServices {

	
	@Autowired
	StaffRepository staffRepo;
	
	@Override
	public Staff saveStaff(StaffDto obj) {	
		String filepath=CustomOperations.getNewFilePath(CustomOperations.createNewDirectoryPath(staffProfilePath),obj.getProfile().getOriginalFilename());
		Staff staff=StaffMapper.mapToEntity(obj);
		staff.setProfilePath(CustomOperations.getDirPath(filepath,"static"));
		try {
			staff=staffRepo.save(staff);
			CustomOperations.saveFile(obj.getProfile(), filepath);
			return staff;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<Staff> getStaffList() {
			
		return staffRepo.findAll();
	}

	
	public Staff getStaff(Long id) {
		
		return staffRepo.findById(id).orElse(null);
	}

	@Override
	public Staff updateStaff(Long id, UpdateStaffDto obj) {
		
		Staff staffObj=staffRepo.findById(id).orElse(null);
		if(staffObj!=null) {
			
			staffObj.setName(obj.getName());
			staffObj.setMobile(obj.getMobile());
			staffObj.setAdharNo(obj.getAdharNo());
			staffObj.setPanNo(obj.getPanNo());
			staffObj.setGender(obj.getGender());
			staffObj.setEmail(obj.getEmail());
			staffObj.setDob(obj.getDob());
			
			staffObj=staffRepo.save(staffObj);
			if(staffObj!=null)
				return staffObj;
			return null;
		}
		return null;
	}

	@Override
	public boolean deleteStaff(Long id) {
		if (staffRepo.existsById(id)) {
			staffRepo.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	
	
}
