package com.gift.service;

import java.util.List;

import com.gift.dto.GiftDTO;

public interface GiftService {

	GiftDTO saveGiftDetails(GiftDTO dto);

	List<GiftDTO> fetchAllGifts();

	GiftDTO fetchGiftById(int giftId);

	GiftDTO updateGiftDetails(int giftId, GiftDTO dto);

	void deleteGiftDetails(int giftId);

}
