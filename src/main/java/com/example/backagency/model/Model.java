package com.example.backagency.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firsname;
    private String lastname;
    private String email;
    private long phone;
    private String inpu;
    private String textarea;

}
