package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vti.entity.Admin;
@Repository
public interface IAdminRepository extends JpaRepository<Admin, Short> {
	public boolean existsByUsername(String name);

	public Boolean existsByUsernameAndPassword(String username, String passwordMd5);
}
