package com.gift.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

	@NotEmpty(message = "User Name must not be empty")
	private String userName;

	@NotEmpty(message = "Mobile Number must not be empty")
	private long mobileNumber;

}
