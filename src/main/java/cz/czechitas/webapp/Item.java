package cz.czechitas.webapp;

public class Item {

    private Long number;
    private String name;
    private double price;
    private String description;

    public Item() {
    }

    public Item(Long number, String name, double price, String description) {
        this.number = number;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long newValue) {
        number = newValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String newValue) {
        name = newValue;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double newValue) {
        price = newValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String newValue) {
        description = newValue;
    }

    @Override
    public String toString() {
        return "Item " +
                "name=\"" + name + "\"" + ", " +
                "price=" + price + ", " +
                "description=\"" + description + "\"";
    }
}
