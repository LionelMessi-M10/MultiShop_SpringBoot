package com.multishop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multishop.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
