package com.vti.service;

import com.vti.dto.AdminDto;

public interface IAdminService {
	public boolean isGroupExistsByID(short id);

	public boolean isGroupExistsByName(String name);

	public Boolean login(AdminDto adminDto);
}
