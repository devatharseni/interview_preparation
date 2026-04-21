package com.example.electrictybillingsystem.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int billid;
    @Column(name="unit")
    private int unit;
    @Column(name="amount")
    private double amount;
    @Column(name="bill date")
    private String date;

    @ManyToOne
    private Customer customer;

}
