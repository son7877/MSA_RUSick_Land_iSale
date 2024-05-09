package com.example.iSale.global.domain.repository;

import com.example.iSale.global.domain.entity.ISale;
import com.example.iSale.global.domain.entity.InterestISale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface InterestISaleRepository extends JpaRepository<InterestISale, UUID> {
Optional<InterestISale> findAllById(UUID id);
Optional<InterestISale> findByIsaleAndUserId(ISale iSale, UUID id);


}
