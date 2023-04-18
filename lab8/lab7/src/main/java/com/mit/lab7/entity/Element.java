package com.mit.lab7.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name="element")
public class Element {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private  String images;
    private int price;
    private String name;
}
