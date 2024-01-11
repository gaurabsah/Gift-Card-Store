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

import com.gift.dto.GiftDTO;
import com.gift.service.GiftService;

@RestController
@RequestMapping("/api/v1/gift")
public class GiftController {

	@Autowired
	private GiftService giftService;

	@PostMapping("/save")
	public ResponseEntity<GiftDTO> saveGiftDetails(@RequestBody GiftDTO dto) {
		GiftDTO giftDetails = giftService.saveGiftDetails(dto);
		return new ResponseEntity<GiftDTO>(giftDetails, HttpStatus.CREATED);
	}

	@GetMapping("/")
	public ResponseEntity<List<GiftDTO>> fetchAllGiftDetails() {
		List<GiftDTO> allGifts = giftService.fetchAllGifts();
		return new ResponseEntity<List<GiftDTO>>(allGifts, HttpStatus.FOUND);
	}

	@GetMapping("/{giftId}")
	public ResponseEntity<GiftDTO> fetchGiftDetails(@PathVariable int giftId) {
		GiftDTO gift = giftService.fetchGiftById(giftId);
		return new ResponseEntity<GiftDTO>(gift, HttpStatus.FOUND);
	}

	@PutMapping("/update/{giftId}")
	public ResponseEntity<GiftDTO> updateGiftDetails(@PathVariable int giftId, @RequestBody GiftDTO dto) {
		GiftDTO giftDetails = giftService.updateGiftDetails(giftId, dto);
		return new ResponseEntity<GiftDTO>(giftDetails, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{giftId}")
	public ResponseEntity<String> deleteGiftDetails(@PathVariable int giftId) {
		giftService.deleteGiftDetails(giftId);
		return new ResponseEntity<String>("Gift Detail Deleted Successfully", HttpStatus.OK);
	}

}
