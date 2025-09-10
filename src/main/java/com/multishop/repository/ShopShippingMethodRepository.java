package com.multishop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multishop.entity.ShopShippingMethod;

@Repository
public interface ShopShippingMethodRepository extends JpaRepository<ShopShippingMethod, Long> {

}
