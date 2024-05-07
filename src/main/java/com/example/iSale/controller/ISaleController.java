package com.example.iSale.controller;

import com.example.iSale.dto.request.ISaleRequest;
import com.example.iSale.global.domain.entity.ISale;
import com.example.iSale.service.ISaleService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
