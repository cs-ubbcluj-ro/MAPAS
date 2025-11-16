package seminar.group323.Seminar4.domain;

import java.io.Serial;

public class Product extends Entity {
    private String name;
    private double price;
    @Serial
    private static final long serialVersionUID = 1L;

    public Product(int id, String name, double price) {
        super(id);
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + getName() + '\'' +
                ", price=" + getPrice() +
                '}';
    }
}
