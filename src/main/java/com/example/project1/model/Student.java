package com.example.project1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String sid;
    private String name;
    private int ca;
    private int practical;
    private int theory;
    private double final_mark;

    public void cal_final_mark(){
        this.final_mark=ca*02+theory*0.2+practical*0.6;
    }

}
