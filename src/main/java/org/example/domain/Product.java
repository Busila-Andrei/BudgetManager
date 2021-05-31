package org.example.domain;

public class Product {
    private final String name;
    private final double price;

    public Product(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int comparePriceTo(Product element) {
        int res = 0;
        if (this.price < element.getPrice()) {
            res =- 1;
        }
        if (this.price > element.getPrice()) {
            res = 1;
        }
        return res;
    }

    public int compareNameTo(Product element) {

        return this.name.compareTo(element.getName());
    }
}
