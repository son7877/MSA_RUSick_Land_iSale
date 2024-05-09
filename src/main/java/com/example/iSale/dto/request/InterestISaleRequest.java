package com.example.iSale.dto.request;

import com.example.iSale.domain.entity.ISale;
import com.example.iSale.domain.entity.InterestISale;

import java.util.UUID;

public record InterestISaleRequest(
        UUID userId, UUID iSaleId
) {
    public InterestISale toEntity(){
        return InterestISale.builder()
                .userId(userId)
                .isale(ISale.builder().iSaleId(iSaleId).build())
                .build();
    }
}
