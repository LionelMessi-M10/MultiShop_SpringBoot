package com.multishop.service;

import com.multishop.entity.UserEntity;
import com.multishop.model.dto.UserDTO;

public interface UserService {

	void registerAccount(UserDTO userDTO);
	UserEntity getCurrentUser();
	
}
