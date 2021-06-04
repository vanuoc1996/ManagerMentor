package com.vti.service;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.vti.dto.AdminDto;
import com.vti.repository.IAdminRepository;

@Service
public class AdminService implements IAdminService {
	@Autowired
	private IAdminRepository AdminRepository;

	@Override
	public boolean isGroupExistsByID(short id) {
		return AdminRepository.existsById(id);
	}

	@Override
	public boolean isGroupExistsByName(String name) {
		return AdminRepository.existsByUsername(name);
	}

	@Override
	public Boolean login(AdminDto adminDto) {
		String passwordMd5 = DigestUtils.md5DigestAsHex(adminDto.getPassword().getBytes(StandardCharsets.UTF_8));
		return AdminRepository.existsByUsernameAndPassword(adminDto.getUsername(), passwordMd5);
		// mật khẩu đã mã hóa lưu trên database là: 202cb962ac59075b964b07152d234b70
		// mật khẩu chưa mã hóa: 123
	}
}
