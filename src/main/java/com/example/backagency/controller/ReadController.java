package com.example.backagency.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backagency.model.Model;
import com.example.backagency.service.ReadService;


import lombok.AllArgsConstructor;


@RestController

@RequestMapping("/admin")

@AllArgsConstructor
@CrossOrigin("http://localhost:4200")

public class ReadController {


    

    private  ReadService readService;


    @GetMapping("/lire")
    public List <Model> read(){
      return readService.lire();
    }

    @GetMapping("/r")

    public List <Model> r(){
        return readService.lire();
    }

    @GetMapping("/ecrire")
    public List <Model> ecrire(){
      return readService.lire();
    }

}
