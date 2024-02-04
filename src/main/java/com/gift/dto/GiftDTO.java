package com.gift.dto;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GiftDTO {

	@NotEmpty(message = "Gift Number must not be empty")
	private String giftNumber;

	@NotEmpty(message = "Gift amount must not be empty")
	private int amount;

	private LocalDateTime createdAt;

	private LocalDateTime issuedDate;

	private boolean isActive;

}
