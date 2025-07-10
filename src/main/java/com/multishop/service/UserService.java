package com.multishop.service;

import java.util.List;

import com.multishop.entity.User;
import com.multishop.model.dto.UserDTO;
import com.multishop.model.response.UserResponse;

public interface UserService {

	void registerAccount(UserDTO userDTO);

	User getCurrentUser();

	List<UserResponse> findUsersByStatus(Byte status);
}
