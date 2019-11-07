package ru.itpark.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.itpark.model.Product;
import ru.itpark.model.Smartphone;
import ru.itpark.model.TV;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {
    private ProductService service = new ProductService();
    List<Product> target;
    List<Product> result;
    boolean test;

    @BeforeEach
    void initialization()
    {
        service.addAll(
                new Smartphone(1, 10000, "Смартфоны", "Xiaomi a", 1),
                new Smartphone(2, 11000, "Смартфоны", "Xiaomi b", 2),
                new Smartphone(3, 12000, "Смартфоны", "Xiaomi c", 3),
                new Smartphone(4, 13000, "Смартфоны", "Xiaomi d", 4),
                new Smartphone(5, 14000, "Смартфоны", "Xiaomi e", 5),

                new TV(6, 20000, "телевизоры", "LD a", 1),
                new TV(9, 23000, "телевизоры", "LD d", 2),
                new TV(7, 21000, "телевизоры", "LD b", 4),
                new TV(8, 22000, "телевизоры", "LD c", 3),
                new TV(10, 24000, "телевизоры", "LD e", 5),
                new TV(11, 25000, "телевизоры", "LD f", 6),
                new TV(12, 26000, "телевизоры", "LD t", 7)
        );
    }
    @Test
    void add(){
        assertEquals(12 , service.getProducts().size());
    }
    @Test
    void searchByName(){
        target = Arrays.asList(
                new Smartphone(1, 10000, "Смартфоны", "Xiaomi a", 1),
                new Smartphone(2, 11000, "Смартфоны", "Xiaomi b", 2),
                new Smartphone(3, 12000, "Смартфоны", "Xiaomi c", 3),
                new Smartphone(4, 13000, "Смартфоны", "Xiaomi d", 4),
                new Smartphone(5, 14000, "Смартфоны", "Xiaomi e", 5)
        );
        result = service.searchByName("Xia");
        assertEquals(target , result);
    }
    @Test
    void searchByCategory(){
        target = Arrays.asList(
                new TV(6, 20000, "телевизоры", "LD a", 1),
                new TV(7, 21000, "телевизоры", "LD b", 4),
                new TV(8, 22000, "телевизоры", "LD c", 3),
                new TV(9, 23000, "телевизоры", "LD d", 2),
                new TV(10, 24000, "телевизоры", "LD e", 5),
                new TV(11, 25000, "телевизоры", "LD f", 6),
                new TV(12, 26000, "телевизоры", "LD t", 7)
        );
        result = service.searchByCategory("телевизоры");
        assertEquals(target , result);
    }
    @Test
    void pageOutPut(){
        target = Arrays.asList(
                new Smartphone(4, 13000, "Смартфоны", "Xiaomi d", 4),
                new Smartphone(5, 14000, "Смартфоны", "Xiaomi e", 5),

                new TV(6, 20000, "телевизоры", "LD a", 1),
                new TV(9, 23000, "телевизоры", "LD d", 2)
        );
        result = service.pageOutPut(3 , 7);
        assertEquals(target , result);

    }
    @Test
    void sortByName(){
        target = Arrays.asList(
                new TV(6, 20000, "телевизоры", "LD a", 1),
                new TV(7, 21000, "телевизоры", "LD b", 4),
                new TV(8, 22000, "телевизоры", "LD c", 3),
                new TV(9, 23000, "телевизоры", "LD d", 2),
                new TV(10, 24000, "телевизоры", "LD e", 5),
                new TV(11, 25000, "телевизоры", "LD f", 6),
                new TV(12, 26000, "телевизоры", "LD t", 7),

                new Smartphone(1, 10000, "Смартфоны", "Xiaomi a", 1),
                new Smartphone(2, 11000, "Смартфоны", "Xiaomi b", 2),
                new Smartphone(3, 12000, "Смартфоны", "Xiaomi c", 3),
                new Smartphone(4, 13000, "Смартфоны", "Xiaomi d", 4),
                new Smartphone(5, 14000, "Смартфоны", "Xiaomi e", 5)
        );
        result = service.sortByName();
        assertEquals(target , result);
    }
    @Test
    void sortByRating() {
        target = Arrays.asList(
                new Smartphone(1, 10000, "Смартфоны", "Xiaomi a", 1),
                new TV(6, 20000, "телевизоры", "LD a", 1),
                new Smartphone(2, 11000, "Смартфоны", "Xiaomi b", 2),
                new TV(9, 23000, "телевизоры", "LD d", 2),
                new Smartphone(3, 12000, "Смартфоны", "Xiaomi c", 3),
                new TV(8, 22000, "телевизоры", "LD c", 3),
                new Smartphone(4, 13000, "Смартфоны", "Xiaomi d", 4),
                new TV(7, 21000, "телевизоры", "LD b", 4),
                new Smartphone(5, 14000, "Смартфоны", "Xiaomi e", 5),
                new TV(10, 24000, "телевизоры", "LD e", 5),
                new TV(11, 25000, "телевизоры", "LD f", 6),
                new TV(12, 26000, "телевизоры", "LD t", 7)

        );
        result = service.sortByRating();
        assertEquals(target , result);
    }
    @Test
    void sortByPrice(){
        target = Arrays.asList(
                new Smartphone(1, 10000, "Смартфоны", "Xiaomi a", 1),
                new Smartphone(2, 11000, "Смартфоны", "Xiaomi b", 2),
                new Smartphone(3, 12000, "Смартфоны", "Xiaomi c", 3),
                new Smartphone(4, 13000, "Смартфоны", "Xiaomi d", 4),
                new Smartphone(5, 14000, "Смартфоны", "Xiaomi e", 5),

                new TV(6, 20000, "телевизоры", "LD a", 1),
                new TV(7, 21000, "телевизоры", "LD b", 4),
                new TV(8, 22000, "телевизоры", "LD c", 3),
                new TV(9, 23000, "телевизоры", "LD d", 2),
                new TV(10, 24000, "телевизоры", "LD e", 5),
                new TV(11, 25000, "телевизоры", "LD f", 6),
                new TV(12, 26000, "телевизоры", "LD t", 7)
                );
        result = service.sortByPrice();
        assertEquals(target , result);
    }
}