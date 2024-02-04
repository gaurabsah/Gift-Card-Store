package com.gift.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.gift.dto.UserDTO;
import com.gift.entity.User;
import com.gift.exception.ResourceNotFoundException;
import com.gift.repository.UserRepository;
import com.gift.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper mapper;

	private final Logger log = LoggerFactory.getLogger(GiftServiceImpl.class);

	@Override
	public UserDTO saveUserDetails(UserDTO dto) {
		User user = mapper.map(dto, User.class);
		User newUser = userRepository.save(user);
		log.info("New User added successfully...");
		UserDTO userDTO = mapper.map(newUser, UserDTO.class);
		return userDTO;
	}

	@Override
	public List<UserDTO> fetchAllUsers() {
		List<User> userList = userRepository.findAll(Sort.by("userName").ascending());
		log.info("Fetching All User Details...");
		List<UserDTO> userDTO = userList.stream().map(u -> mapper.map(u, UserDTO.class)).collect(Collectors.toList());
		return userDTO;
	}

	@Override
	public UserDTO fetchUserById(int userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User Details with Id: {}" + userId + " not found"));
		log.info("fetching User Details with Id: {}", userId);
		UserDTO userDTO = mapper.map(user, UserDTO.class);
		return userDTO;
	}

	@Override
	public UserDTO updateUserDetails(int userId, UserDTO dto) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User Details with Id: {}" + userId + " not found"));
		log.info("fetching User Details with Id: {}", userId);
		user.setMobileNumber(dto.getMobileNumber());
		user.setUserName(dto.getUserName());
		User newUser = userRepository.save(user);
		log.info("User Details updated successfully...");
		UserDTO userDTO = mapper.map(newUser, UserDTO.class);
		return userDTO;
	}

	@Override
	public void deleteUserDetails(int userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User Details with Id: {}" + userId + " not found"));
		log.info("fetching User Details with Id: {}", userId);
		userRepository.delete(user);
		log.info("User Details Deleted Successfully...");

	}

}
