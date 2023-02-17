package Elements;

import java.io.Serializable;

public class Element implements Serializable {

    private static final long serialVersionUID = 1L;


    private int id;
    private  String images;
    private int price;
    private String name;


    public Element(){}

    public Element(int id, String images, int price, String name) {
        this.id = id;
        this.images = images;
        this.price = price;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "{\"id\": \""+id+"\", \"image\": \""+images+"\", \"price\": \""+price+"\", \"name\": "+name+"}";
    }

}
