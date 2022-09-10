package com.transaction.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transaction.Entity.Rekening;
import com.transaction.Services.RekeningService;
import com.transaction.dto.TransferRequest;

@RestController
@RequestMapping("/rekening")
public class RekeningController {
    
    @Autowired
    private RekeningService rekeningService;

    @PostMapping
    public Rekening create(@RequestBody Rekening rekening){
        return rekeningService.create(rekening);
    }

    @GetMapping
    public Iterable<Rekening> findAll(){
        return rekeningService.findAll();
    }

    @PostMapping("/transfer")
    public void transfer(@RequestBody TransferRequest transferRequest){
        rekeningService.transfer(transferRequest.getNorek1(), transferRequest.getNorek2(), transferRequest.getAmount());
    }

}
