package com.example.iSale.service;

import com.example.iSale.dto.request.ISaleEnrollRequest;
import com.example.iSale.dto.request.ISaleRequest;
import com.example.iSale.global.domain.entity.ISale;
import java.util.List;

public interface ISaleService {
    void save(ISaleRequest req);
    ISale getISaleById(String id);
    List<ISale> getAllISale();
    void enrollSave(String id, ISaleEnrollRequest req);
}
