package com.example.iSale.controller;

import com.example.iSale.dto.request.ISaleRequest;
import com.example.iSale.dto.request.InterestISaleRequest;
import com.example.iSale.global.domain.entity.ISale;
import com.example.iSale.global.domain.entity.InterestISale;
import com.example.iSale.service.ISaleService;
import java.util.List;
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

    //관심 분양
    @GetMapping("/interest")
    public InterestISale getInterestISale(@RequestParam String id){
        return iSaleService.getInterestById(id);
    }

    @PostMapping("/interest")
    public void addOrDeleteInterest(@RequestBody InterestISaleRequest interestISaleRequest){
        return iSaleService.
    }

}
