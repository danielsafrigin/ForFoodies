package com.forfoodies.api.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.forfoodies.api.dao.RoleDao;
import com.forfoodies.api.dao.UserDao;
import com.forfoodies.api.models.Role;

@Component
public class RoleComponent {

	private SessionComponent sessionComponent;
	private RoleDao roleDao;
	private UserDao userDao;

	@Autowired
	public RoleComponent(UserDao userDao, RoleDao roleDao ,SessionComponent sessionComponent) {
		this.userDao = userDao;
		this.sessionComponent = sessionComponent;
		this.roleDao = roleDao;
	}
	
	public boolean hasPermission(String token, int permissionId) {
		System.out.println(10);
		int userId = this.userDao.getUserIdByToken(token);
		System.out.println(11);
		int roleId = this.roleDao.getRoleIdByUserId(userId);
		System.out.println(12);
		return this.roleDao.roleHasPermission(roleId, permissionId);
	}
	
	public Integer getRoleByUserId(int userId) {
		return this.roleDao.getRoleIdByUserId(userId);
	}


	public void insertRoleToUserHasRole(int userId, int roleId) {
		this.roleDao.insertRoleToUserHasRole(userId, roleId);
	}
	
}
