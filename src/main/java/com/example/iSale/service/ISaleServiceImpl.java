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
    public List<InterestISale> getInterestById(UUID id) {
        Optional<InterestISale> byId = interestISaleRepository.findAllById(id);
        if(byId.isEmpty()) throw new IllegalArgumentException("리스트 없음");
        return byId.get().getIsale().getInterestISales();
    }

    @Override
    public void addOrDeleteInterest(InterestISaleRequest request) {
        //DB에 저장되어있는 Interest 테이블의 iSale의 ID 가져오기
//        Optional<InterestISale> interest = interestISaleRepository.findByIsale(request.isale());
        InterestISale entity = request.toEntity();
        Optional<InterestISale> byIsale = interestISaleRepository.findByIsaleAndUserId(entity.getIsale(),entity.getUserId());
        //ByIsale 유무 확인
        //ID가 있다면 삭제
        if(byIsale.isPresent()) interestISaleRepository.delete(byIsale.get());
        //ID가 없다면 추가
//        interest.ifPresent(interestISaleRepository::delete);
        else interestISaleRepository.save(entity);
    }
}
