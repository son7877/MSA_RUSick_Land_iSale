package com.example.iSale.service;

import com.example.iSale.dto.request.InterestISaleRequest;
import com.example.iSale.global.domain.entity.ISale;
import com.example.iSale.global.domain.entity.InterestISale;
import com.example.iSale.global.domain.repository.ISaleRepository;
import com.example.iSale.global.domain.repository.InterestISaleRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ISaleServiceTest {
    @Autowired
    ISaleRepository iSaleRepository;
    @Autowired
    InterestISaleRepository interestISaleRepository;
    @Autowired
    ISaleService iSaleService;

    @Test
    @Transactional
    void addOrDeleteInterest() {
        //give
        ISale iSale = new ISale();
        iSaleRepository.save(iSale);
        UUID userId = UUID.randomUUID();
        InterestISaleRequest request = new InterestISaleRequest(userId,iSale.getISaleId());

        //when
        iSaleService.addOrDeleteInterest(request);

        //then
        Optional<InterestISale> byIsaleAndUserId = interestISaleRepository.findByIsaleAndUserId(iSale, userId);
        assertTrue(byIsaleAndUserId.isPresent());
    }
}