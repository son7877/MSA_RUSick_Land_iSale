package com.example.iSale.service;

import com.example.iSale.dto.request.ISaleRequest;
import com.example.iSale.dto.request.InterestISaleRequest;
import com.example.iSale.global.domain.entity.ISale;
import com.example.iSale.global.domain.entity.InterestISale;
import com.example.iSale.global.domain.repository.ISaleRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.iSale.global.domain.repository.InterestISaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;

@Service
@RequiredArgsConstructor
public class ISaleServiceImpl implements ISaleService{
    private final ISaleRepository iSaleRepository;
    private final InterestISaleRepository interestISaleRepository;

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
    public List<InterestISale> getInterestById(String id) {
//        Optional<InterestISale> byId =  interestISaleRepository.findById(UUID.fromString(id));
//        Optional<InterestISale> interestISales = interestISaleRepository.findById(UUID.fromString(id));
//        return interestISales.orElseThrow(() -> new IllegalArgumentException("즐겨찾기 정보 없음"));
        Optional<InterestISale> byId = interestISaleRepository.findAllById(UUID.fromString(id));
        return byId.orElseThrow(() -> new IllegalArgumentException("즐겨찾기 정보 없음"));
    }

    @Override
    public void addOrDeleteInterest(InterestISaleRequest interestISaleRequest) {
        Optional<InterestISale> interest = InterestISaleRepository.findById(interestISaleRequest.)
    }
}
