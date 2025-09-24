package com.multishop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multishop.entity.Shop;
import com.multishop.entity.ShopStaff;

@Repository
public interface ShopStaffRepository extends JpaRepository<ShopStaff, Long> {

	List<ShopStaff> findByShop(Shop shop);
	
}
