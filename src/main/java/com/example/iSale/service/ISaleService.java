package com.example.iSale.service;

import com.example.iSale.dto.request.ISaleEnrollRequest;
import com.example.iSale.dto.request.ISaleRequest;
import com.example.iSale.dto.request.InterestISaleRequest;
import com.example.iSale.domain.entity.ISale;
import com.example.iSale.domain.entity.InterestISale;

import java.util.List;
import java.util.UUID;

public interface ISaleService {
    void save(ISaleRequest req);
    ISale getISaleById(String id);
    List<ISale> getAllISale();
    void enrollSave(String id, ISaleEnrollRequest req);
    List<InterestISale> getInterestById(UUID Id);
    void addOrDeleteInterest(InterestISaleRequest request);
}
