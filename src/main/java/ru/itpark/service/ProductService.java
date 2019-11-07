package ru.itpark.service;

import ru.itpark.comparator.SearchByNameComparator;
import ru.itpark.comparator.SearchByRatingComparator;
import ru.itpark.model.Product;

import java.util.*;

public class ProductService {
    private final List<Product> products = new ArrayList<>();

    public void addAll(Product ... product){
          Collections.addAll(products, product);
    }
    public List<Product> searchByName(String name){
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if(product.getName().startsWith(name)){
                result.add(product);
            }
        }
        Collections.sort(result , new SearchByNameComparator());
        return result;
    }
    public List<Product> searchByCategory(String category){
        List<Product> result = new ArrayList<>();
        for(Product product : products){
            if(product.getCategory().equals(category)){
                result.add(product);
            }
        }
        Collections.sort(result , new SearchByNameComparator());
        return result;
    }
    public List<Product> sortByPrice(){
        List<Product> result = new ArrayList<>(products);
        Collections.sort(result);
        return result;
    }
    public List<Product> sortByName(){
        List<Product> result = new ArrayList<>(products);
        Collections.sort(result , new SearchByNameComparator());
        return result;
    }
    public List<Product> pageOutPut(int firsIndex , int lastIndex){
        List<Product> result = new ArrayList<>();
        if(products.size() >= lastIndex){
            result = products.subList(firsIndex , lastIndex);
        }else if(products.size() >= firsIndex){
            result = products.subList(firsIndex , products.size());
        }
        Collections.sort(result);
        return result;
    }



    public List<Product> sortByRating() {
        List<Product> result = new ArrayList<>(products);
        result.sort(new SearchByRatingComparator());
        return result;
    }


    public List<Product> getProducts() {
        return products;
    }
}

