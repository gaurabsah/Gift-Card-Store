package com.gift.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.gift.dto.GiftDTO;
import com.gift.entity.Gift;
import com.gift.exception.ResourceNotFoundException;
import com.gift.repository.GiftRepository;
import com.gift.service.GiftService;

@Service
public class GiftServiceImpl implements GiftService {

	@Autowired
	private GiftRepository giftRepo;

	@Autowired
	private ModelMapper mapper;

	private final Logger log = LoggerFactory.getLogger(GiftServiceImpl.class);

	@Override
	public GiftDTO saveGiftDetails(GiftDTO dto) {
		Gift gift = mapper.map(dto, Gift.class);
		String uuid = UUID.randomUUID().toString();
		gift.setGiftNumber(uuid);
		Gift newGift = giftRepo.save(gift);
		log.info("New Gift Details added...");
		GiftDTO giftDTO = mapper.map(newGift, GiftDTO.class);
		return giftDTO;
	}

	@Override
	public List<GiftDTO> fetchAllGifts() {
		List<Gift> giftList = giftRepo.findAll(Sort.by("isActive").ascending());
		log.info("Fetching All Gift Details Successfully...");
		List<GiftDTO> giftDTO = giftList.stream().map(t -> mapper.map(t, GiftDTO.class)).collect(Collectors.toList());
		return giftDTO;
	}

	@Override
	public GiftDTO fetchGiftById(int giftId) {
		Gift gift = giftRepo.findById(giftId)
				.orElseThrow(() -> new ResourceNotFoundException("Gift Card with Id: {}" + giftId + " not found"));
		log.info("Fetching Gift Details with ID: {}", giftId);
		GiftDTO giftDTO = mapper.map(gift, GiftDTO.class);
		return giftDTO;
	}

	@Override
	public GiftDTO updateGiftDetails(int giftId, GiftDTO dto) {
		Gift gift = giftRepo.findById(giftId)
				.orElseThrow(() -> new ResourceNotFoundException("Gift Card with Id: {}" + giftId + " not found"));
		log.info("Fetching Gift Details with ID: {}", giftId);
		gift.setActive(dto.isActive());
		gift.setAmount(dto.getAmount());
		gift.setCreatedAt(dto.getCreatedAt());
		gift.setGiftNumber(dto.getGiftNumber());
		gift.setIssuedDate(dto.getIssuedDate());
		Gift newGift = giftRepo.save(gift);
		log.info("Gift Details with ID: {} Updated Successfully", giftId);
		GiftDTO giftDTO = mapper.map(newGift, GiftDTO.class);
		return giftDTO;
	}

	@Override
	public void deleteGiftDetails(int giftId) {
		Gift gift = giftRepo.findById(giftId)
				.orElseThrow(() -> new ResourceNotFoundException("Gift Card with Id: {}" + giftId + " not found"));
		log.info("Fetching Gift Details with ID: {}", giftId);
		giftRepo.delete(gift);
		log.info("Gift Details deleted Successfully...");

	}

}
