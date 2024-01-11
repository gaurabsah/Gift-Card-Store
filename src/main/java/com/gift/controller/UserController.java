package com.gift.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gift.dto.UserDTO;
import com.gift.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/save")
	public ResponseEntity<UserDTO> saveUserDetails(@RequestBody UserDTO dto) {
		UserDTO userDetails = userService.saveUserDetails(dto);
		return new ResponseEntity<UserDTO>(userDetails, HttpStatus.CREATED);
	}

	@GetMapping("/")
	public ResponseEntity<List<UserDTO>> fetchAllUserDetails() {
		List<UserDTO> allUsers = userService.fetchAllUsers();
		return new ResponseEntity<List<UserDTO>>(allUsers, HttpStatus.FOUND);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<UserDTO> fetchUserDetails(@PathVariable int userId) {
		UserDTO user = userService.fetchUserById(userId);
		return new ResponseEntity<UserDTO>(user, HttpStatus.FOUND);
	}

	@PutMapping("/update/{userId}")
	public ResponseEntity<UserDTO> updateGiftDetails(@PathVariable int userId, @RequestBody UserDTO dto) {
		UserDTO userDetails = userService.updateUserDetails(userId, dto);
		return new ResponseEntity<UserDTO>(userDetails, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<String> deleteGiftDetails(@PathVariable int userId) {
		userService.deleteUserDetails(userId);
		return new ResponseEntity<String>("User Detail Deleted Successfully", HttpStatus.OK);
	}

}
