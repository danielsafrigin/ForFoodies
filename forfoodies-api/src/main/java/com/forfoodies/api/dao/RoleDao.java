package com.forfoodies.api.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.forfoodies.api.models.Role;
import com.forfoodies.api.repositories.RoleRepository;

@Component
public class RoleDao {

	private RoleRepository roleRepository;

	@Autowired
	public RoleDao(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	public Integer getRoleIdByUserId(int userId) {
		return this.roleRepository.getRoleIdByUserId(userId);
	}

	public Boolean roleHasPermission(int roleId, int permissionId) {
		if (this.roleRepository.roleHasPermission(roleId, permissionId) == null)
			return false;
		return true;
	}

	public void insertRoleToUserHasRole(int userId, int roleId) {
		this.roleRepository.insertRoleToUserHasRole(userId, roleId);
	}
}
