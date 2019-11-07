package ru.itpark;

import ru.itpark.model.Product;
import ru.itpark.model.Smartphone;
import ru.itpark.model.TV;
import ru.itpark.service.ProductService;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        ProductService service = new ProductService();
        service.addAll(
                new Smartphone(1, 100, "Смартфоны", "Xiaomi b", 1),
                new Smartphone(2, 11000, "Смартфоны", "Xiaomi a", 2),
                new Smartphone(3, 12000, "Смартфоны", "Xiaomi b", 3),
                new Smartphone(4, 13000, "Смартфоны", "Xiaomi c", 4),
                new Smartphone(5, 1400, "Смартфоны", "Xiaomi b", 5),

                new TV(6, 20000, "телевизоры", "LD a", 1),
                new TV(9, 23000, "телевизоры", "LD d", 2),
                new TV(7, 21000, "телевизоры", "LD b", 2),
                new TV(8, 22000, "телевизоры", "LD c", 3),
                new TV(10, 24000, "телевизоры", "LD e", 5)
        );


        List<Product> list = service.searchByName("Xia");
        for (Product product : list) {
            System.out.println(product.getName() + " " +  product.getPrice());
        }
    }
}
