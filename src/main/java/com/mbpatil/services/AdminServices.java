package com.mbpatil.services;

import com.mbpatil.dto.admin.AdminDto;
import com.mbpatil.models.Admin;

public interface AdminServices {

	 AdminDto saveCredenTials(AdminDto obj);
	 Admin findUser(AdminDto obj);
}
