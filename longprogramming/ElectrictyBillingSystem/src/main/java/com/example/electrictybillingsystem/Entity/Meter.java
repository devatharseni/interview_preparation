package com.example.electrictybillingsystem.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Meter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int meterid;
    @Column(name="type")
    private String type;

    @ManyToOne
    private Customer customer;
}
