package com.example.iSale.global.domain.repository;

import com.example.iSale.global.domain.entity.InterestISale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InterestISaleRepository extends JpaRepository<InterestISale, UUID> {

}
