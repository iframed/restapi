package com.example.backagency.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.backagency.model.Model;
import com.example.backagency.repo.ReadRepo;


import lombok.AllArgsConstructor;

@Service 
@AllArgsConstructor
public class ReadSerciceimpl  implements ReadService{


    private final ReadRepo readRepo;

    
    @Override
    public List<Model> lire() {
        
        return readRepo.findAll();
        
    }
    

}
