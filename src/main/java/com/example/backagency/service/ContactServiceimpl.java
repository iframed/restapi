package com.example.backagency.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.backagency.model.Model;
import com.example.backagency.repo.Repo;

import lombok.AllArgsConstructor;

@Service 
@AllArgsConstructor

public class ContactServiceimpl  implements ContactService {
     
   private final Repo repo ;



    @Override
    public Model cree(Model model) {
        
        return repo.save(model);
    }

    @Override
    public List<Model> lire() {
        
        return repo.findAll();
        
    }
    





}
