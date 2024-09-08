package com.example.backagency.controller;



import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.backagency.model.Model;
import com.example.backagency.service.ContactService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import org.springframework.web.bind.annotation.RequestMapping;









@RestController

@RequestMapping("/contact")

@CrossOrigin("https://frontagency.onrender.com")


@AllArgsConstructor

public class Controller {



  
private  ContactService contactService;

@PostMapping( path = "/create")
public Model create(@RequestBody Model model){

    return contactService.cree(model);
}

 @GetMapping("/lire")
  public List <Model> read(){
    return contactService.lire();
  }
}

@GetMapping("/write")
public List <Model> write(){
    return readService.lire();
}







