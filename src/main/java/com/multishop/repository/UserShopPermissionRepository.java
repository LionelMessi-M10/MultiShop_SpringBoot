package com.multishop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multishop.entity.Shop;
import com.multishop.entity.User;
import com.multishop.entity.UserShopPermissionId;
import com.multishop.entity.UserShopPermission;

@Repository
public interface UserShopPermissionRepository extends JpaRepository<UserShopPermission, UserShopPermissionId> {

	Optional<User> findByUserAndShopAndPermissionName(User user, Shop shop, String string);

}
