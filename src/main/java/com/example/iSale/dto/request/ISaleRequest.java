package com.example.iSale.dto.request;

import com.example.iSale.global.domain.entity.ISale;
import java.util.Date;

public record ISaleRequest(
    Date iSale_in,
    Long iSale_sell_price,
    Integer iSale_category,
    String iSale_name,
    String iSale_area,
    String iSale_address
) {
    public ISale toEntity(){
        return ISale.builder()
            .iSale_in(iSale_in)
            .iSale_sell_price(iSale_sell_price)
            .iSale_category(iSale_category)
            .iSale_name(iSale_name)
            .iSale_area(iSale_area)
            .iSale_address(iSale_address)
            .build();
    }
}
