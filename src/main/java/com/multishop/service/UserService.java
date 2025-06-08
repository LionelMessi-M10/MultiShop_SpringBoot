package com.multishop.service;

import com.multishop.entity.User;
import com.multishop.model.dto.UserDTO;

public interface UserService {

	void registerAccount(UserDTO userDTO);
	User getCurrentUser();
	
}
