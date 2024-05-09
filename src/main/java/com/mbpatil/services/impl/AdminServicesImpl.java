package com.mbpatil.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbpatil.Repository.AdminRepository;
import com.mbpatil.dto.admin.AdminDto;
import com.mbpatil.mapper.AdminMapper;
import com.mbpatil.models.Admin;
import com.mbpatil.services.AdminServices;

@Service
public class AdminServicesImpl implements AdminServices {

	@Autowired
	AdminRepository adminRepo;
	
	
	@Override
	public AdminDto saveCredenTials(AdminDto obj) {
		return AdminMapper.mapTODto(adminRepo.save(AdminMapper.mapTOEntity(obj)));
	
	}


	@Override
	public Admin findUser(AdminDto obj) {
		try {
		Admin user=adminRepo.findAdmin(obj.getUsername(),obj.getPassword());
		if(user !=null)
			return user;
		return null;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
			// TODO: handle exception
		}
	}
	
	

}
