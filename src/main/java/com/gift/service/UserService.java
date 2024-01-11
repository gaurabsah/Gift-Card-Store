package com.gift.service;

import java.util.List;

import com.gift.dto.UserDTO;

public interface UserService {

	UserDTO saveUserDetails(UserDTO dto);

	List<UserDTO> fetchAllUsers();

	UserDTO fetchUserById(int userId);

	UserDTO updateUserDetails(int userId, UserDTO dto);

	void deleteUserDetails(int userId);

}
