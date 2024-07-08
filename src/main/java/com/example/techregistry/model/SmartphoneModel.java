package com.example.techregistry.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Setter
@Getter
@Entity
public class SmartphoneModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;

    private String name;
    private String serialNumber;
    private String color;
    private String size;
    private double price;
    private String memory;
    private int camerasCount;
    private boolean inStock;
}
