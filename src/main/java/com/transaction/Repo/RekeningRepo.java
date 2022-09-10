package com.transaction.Repo;

import org.springframework.data.repository.CrudRepository;

import com.transaction.Entity.Rekening;

public interface RekeningRepo extends CrudRepository<Rekening, Long> {
 
    public Rekening findByNorek(String norek);
}
