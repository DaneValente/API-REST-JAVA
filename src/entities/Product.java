package entities;

public class Product {
    private Integer Id;
    private String Name;
    private Double Price;
    private Integer Quantity;

    public Product(Integer id, String name, Double price, Integer quantity) {
        Id = id;
        Name = name;
        Price = price;
        Quantity = quantity;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }


}
