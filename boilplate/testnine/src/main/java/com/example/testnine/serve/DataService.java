package com.example.testnine.serve;

import com.example.testnine.Repository.IdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DataService {
    @Autowired
    private IdenRepository idenRepository;
public getIden(String id){
    Enty enty = IdenRepository.foundById(id);
    return ResponseEntity.body(enty);
}
}
