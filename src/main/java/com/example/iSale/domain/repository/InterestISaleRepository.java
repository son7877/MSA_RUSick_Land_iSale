package com.example.iSale.domain.repository;

import com.example.iSale.domain.entity.InterestISale;
import com.example.iSale.domain.entity.ISale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface InterestISaleRepository extends JpaRepository<InterestISale, UUID> {
Optional<InterestISale> findAllById(UUID id);
Optional<InterestISale> findByIsaleAndUserId(ISale iSale, UUID id);


}
