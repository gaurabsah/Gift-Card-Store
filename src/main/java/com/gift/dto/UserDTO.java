package com.gift.dto;

import jakarta.validation.constraints.NotEmpty;

public class UserDTO {

	@NotEmpty(message = "User Name must not be empty")
	private String userName;

	@NotEmpty(message = "Mobile Number must not be empty")
	private long mobileNumber;

	public UserDTO() {

	}

	public UserDTO(@NotEmpty(message = "User Name must not be empty") String userName,
			@NotEmpty(message = "Mobile Number must not be empty") long mobileNumber) {
		this.userName = userName;
		this.mobileNumber = mobileNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

}
