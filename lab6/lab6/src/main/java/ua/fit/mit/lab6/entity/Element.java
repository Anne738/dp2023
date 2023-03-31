package ua.fit.mit.lab6.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="element")
public class Element {
    @Id
    @GeneratedValue
    private long id;
    private  String images;
    private int price;
    private String name;
}
