package com.example.iSale.service;

import com.example.iSale.dto.request.ISaleRequest;
import com.example.iSale.dto.request.InterestISaleRequest;
import com.example.iSale.global.domain.entity.ISale;
import com.example.iSale.global.domain.entity.InterestISale;

import java.util.List;

public interface ISaleService {
    void save(ISaleRequest req);
    ISale getISaleById(String id);
    List<ISale> getAllISale();
    List<InterestISale> getInterestById(String Id);
    void addOrDeleteInterest(InterestISaleRequest interestISaleRequest);
}
