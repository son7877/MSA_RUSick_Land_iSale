package com.example.iSale.service;

import com.example.iSale.dto.request.ISaleRequest;
import com.example.iSale.global.domain.entity.ISale;
import com.example.iSale.global.domain.repository.ISaleRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ISaleServiceImpl implements ISaleService{
    private final ISaleRepository iSaleRepository;

    @Override
    public void save(ISaleRequest req) {
        iSaleRepository.save(req.toEntity());
    }

    @Override
    public ISale getISaleById(String id) {
        Optional<ISale> byId = iSaleRepository.findById(UUID.fromString(id));
        return byId.orElseThrow(() -> new IllegalArgumentException("분양 정보 없음"));
    }

    @Override
    public List<ISale> getAllISale() {
        return iSaleRepository.findAll();
    }
}
