package com.example.iSale.controller;

import com.example.iSale.dto.request.ISaleEnrollRequest;
import com.example.iSale.dto.request.ISaleRequest;
import com.example.iSale.dto.request.InterestISaleRequest;
import com.example.iSale.domain.entity.ISale;
import com.example.iSale.domain.entity.InterestISale;
import com.example.iSale.service.ISaleService;
import java.util.List;
import java.util.UUID;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/iSale")
@RequiredArgsConstructor
public class ISaleController {
    private final ISaleService iSaleService;

    @PostMapping
    public void addISale(@RequestBody ISaleRequest req){
        iSaleService.save(req);
    }

    @GetMapping()
    public List<ISale> getAllISale(){
        return iSaleService.getAllISale();
    }

    @GetMapping("{id}")
    public ISale getISale(@PathVariable String id){
        return iSaleService.getISaleById(id);
    }

    // 분양 신청
    @PostMapping("{id}/enroll")
    public void enrollISale(@PathVariable String id, @RequestBody ISaleEnrollRequest req){
        iSaleService.enrollSave(id, req);
    }
    //관심 분양

    //관심 분양 리스트 출력
    @GetMapping("/interest")
    public List<InterestISale> getInterestISale(@RequestParam UUID id){
        return iSaleService.getInterestById(id);
    }

    //관심 분양 추가, 추가돼있다면 삭제 작업
    @PostMapping("/interest")
    public void addOrDeleteInterest(@RequestBody InterestISaleRequest request){
        iSaleService.addOrDeleteInterest(request);
    }

}
