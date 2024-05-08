package com.example.iSale.service;

import com.example.iSale.dto.request.ISaleEnrollRequest;
import com.example.iSale.dto.request.ISaleRequest;
import com.example.iSale.global.domain.entity.ISale;
import com.example.iSale.global.domain.entity.ISaleEnroll;
import com.example.iSale.global.domain.repository.ISaleEnrollRepository;
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
    private final ISaleEnrollRepository iSaleEnrollRepository;
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

    @Override
    public void enrollSave(String id, ISaleEnrollRequest req) {
        Optional<ISale> byId = iSaleRepository.findById(UUID.fromString(id));
        ISale iSale = byId.orElseThrow(() -> new IllegalArgumentException(""));
        ISaleEnroll iSaleEnroll = ISaleEnroll.builder()
            .iSale(iSale)
            .userId() // todo token 까서 id값 넣기
            .income(req.income())
            .child(req.child())
            .age() // todo token 까서 age 넣기
            .qualTF(null)
            .build();
        iSaleEnrollRepository.save(iSaleEnroll);
    }

}
