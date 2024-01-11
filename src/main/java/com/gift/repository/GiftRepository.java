package com.gift.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gift.entity.Gift;

@Repository
public interface GiftRepository extends JpaRepository<Gift, Integer> {

}
