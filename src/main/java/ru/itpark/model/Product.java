package ru.itpark.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data

public class Product implements Comparable<Product> {
    private int id;
    private int price;
    private String category;
    private String name;
    private int rating;


    @Override
    public int compareTo(Product o) {
        return price - o.price;
    }
}
