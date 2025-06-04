package com.multishop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.multishop.entity.UserEntity;
import com.multishop.model.dto.UserDTO;
import com.multishop.repository.RoleRepository;
import com.multishop.repository.UserRepository;
import com.multishop.service.UserService;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder byBCryptPasswordEncoder;

	@Transactional
	@Override
	public void registerAccount(UserDTO userDTO) {
		UserEntity newUser = new UserEntity();
		
		newUser.setFullName(userDTO.getFirstName().trim() + " " + userDTO.getLastName().trim());
		newUser.setEmail(userDTO.getEmail());
		newUser.setPassword(byBCryptPasswordEncoder.encode(userDTO.getPassword()));
		newUser.setGender(userDTO.getGender());
		newUser.setRoles(List.of(roleRepository.findById(userDTO.getRoleId()).get()));
		
		userRepository.save(newUser);
	}

	@Override
	public UserEntity getCurrentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String email = authentication.getName();
	    return userRepository.findByEmail(email);
	}

}
