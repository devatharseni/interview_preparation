package com.example.electrictybillingsystem.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerid;
    @Column(name="customer name")
    private String name;
    @Column(name="customer address")
    private String address;
    @Column(name="customer phno")
    private long phno;

}
