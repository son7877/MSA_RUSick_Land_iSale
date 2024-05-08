package com.example.iSale.service;

import com.example.iSale.dto.request.ISaleRequest;
import com.example.iSale.dto.request.InterestISaleRequest;
import com.example.iSale.global.domain.entity.ISale;
import com.example.iSale.global.domain.entity.InterestISale;

import java.util.List;
import java.util.UUID;

public interface ISaleService {
    void save(ISaleRequest req);
    ISale getISaleById(String id);
    List<ISale> getAllISale();
    List<InterestISale> getInterestById(UUID Id);
    void addOrDeleteInterest(InterestISaleRequest request);
}
