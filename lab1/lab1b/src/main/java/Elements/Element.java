package Elements;

public class Element {
    private String name;
    private int price;

    private  String images;



    public Element(String images, int price, String name) {
        this.name = name;
        this.price = price;
        this.images = images;
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

    public String toString() {
        return "{\"Images\": \""+images+"\", \"Price\": \""+price+"\", \"Name\": "+name+"}";
    }

}
