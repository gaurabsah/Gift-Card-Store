package com.gift.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "gift")
public class Gift {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "giftId")
	private int id;

	@Column(name = "giftNumber")
	private String giftNumber;

	@Column(name = "giftAmount")
	private int amount;

	@Column(name = "issuedDate")
	private Date issuedDate;

	@Column(name = "isActive")
	private boolean isActive;

	public Gift() {

	}

	public Gift(int id, String giftNumber, int amount, Date issuedDate, boolean isActive) {
		this.id = id;
		this.giftNumber = giftNumber;
		this.amount = amount;
		this.issuedDate = issuedDate;
		this.isActive = isActive;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
