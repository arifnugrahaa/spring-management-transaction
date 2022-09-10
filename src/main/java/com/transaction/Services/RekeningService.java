package com.transaction.Services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transaction.Entity.Rekening;
import com.transaction.Repo.RekeningRepo;

@Service
public class RekeningService {
    
    @Autowired
    private RekeningRepo rekeningRepo;

    public Rekening create(Rekening rekening){
        return rekeningRepo.save(rekening);
    }

    public Iterable<Rekening> findAll(){
        return rekeningRepo.findAll();
    }

    @Transactional
    public void transfer(String norek1, String norek2, Double amount){
        
        Rekening rekening1 = rekeningRepo.findByNorek(norek1);

        if(rekening1 == null){
            throw new RuntimeException("Norek1 tidak valid");
        }

        if(rekening1.getSaldo() < amount){
            throw new RuntimeException("Saldo tidak cukup");
        }

        rekening1.setSaldo(rekening1.getSaldo() - amount);
        rekeningRepo.save(rekening1);

        Rekening rekening2 = rekeningRepo.findByNorek(norek2);

        if(rekening2 == null){
            throw new RuntimeException("Norek2 tidak valid");
        }

        rekening2.setSaldo(rekening2.getSaldo() + amount);
        rekeningRepo.save(rekening2);
    }
}
