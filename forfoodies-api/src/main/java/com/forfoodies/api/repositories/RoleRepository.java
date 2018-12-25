package com.forfoodies.api.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.forfoodies.api.models.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {

	@Query(value = "SELECT role_id FROM user_has_role WHERE user_id = ?1", nativeQuery = true)
	Integer getRoleIdByUserId(int userId);

	@Query(value = "SELECT role_id FROM role_has_permission WHERE role_id = ?1 AND permission_id = ?2", nativeQuery = true)
	Integer roleHasPermission(int roleId, int permissionId);

	@Modifying
	@Transactional
	@Query(value = "INSERT INTO user_has_role(user_id, role_id) VALUES (?,?)", nativeQuery = true)
	void insertRoleToUserHasRole(int userId, int roleId);

}
