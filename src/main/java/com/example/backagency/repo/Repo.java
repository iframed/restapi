package com.example.backagency.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backagency.model.Model;



@Repository

public interface Repo extends JpaRepository <Model,Long> {

    
}
