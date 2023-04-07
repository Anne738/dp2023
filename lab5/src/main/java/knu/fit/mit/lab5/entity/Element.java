package knu.fit.mit.lab5;


import jakarta.persistence.*;

@Entity
@Table(name = "element")
public class Element {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String images;
    private int price;
    private String name;

    public Element(){

    }

    public Element(Long id, String images, int price, String name) {
        this.id = id;
        this.images = images;
        this.price = price;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
