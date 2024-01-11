package com.gift.dto;

import java.util.Date;

import jakarta.validation.constraints.NotEmpty;

public class GiftDTO {

	@NotEmpty(message = "Gift Number must not be empty")
	private String giftNumber;

	@NotEmpty(message = "Gift amount must not be empty")
	private int amount;

	private Date issuedDate;

	private boolean isActive;

	public GiftDTO() {

	}

	public GiftDTO(@NotEmpty(message = "Gift Number must not be empty") String giftNumber,
			@NotEmpty(message = "Gift amount must not be empty") int amount, Date issuedDate, boolean isActive) {
		this.giftNumber = giftNumber;
		this.amount = amount;
		this.issuedDate = issuedDate;
		this.isActive = isActive;
	}

	public String getGiftNumber() {
		return giftNumber;
	}

	public void setGiftNumber(String giftNumber) {
		this.giftNumber = giftNumber;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
