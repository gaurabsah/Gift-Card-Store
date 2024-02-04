package com.gift.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

	@CreationTimestamp
	@Column(name = "createdOn")
	private LocalDateTime createdAt;

	@Column(name = "issuedDate")
	@UpdateTimestamp
	private LocalDateTime issuedDate;

	@Column(name = "isActive")
	private boolean isActive;

}
