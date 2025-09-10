package com.multishop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multishop.entity.RolePermission;
import com.multishop.entity.RolePermissionId;

@Repository
public interface RolePermissionRepository extends JpaRepository<RolePermission, RolePermissionId> {

}
