package com.multishop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multishop.entity.UserShopId;
import com.multishop.entity.UserShopPermission;

@Repository
public interface UserShopPermissionRepository extends JpaRepository<UserShopPermission, UserShopId> {

}
