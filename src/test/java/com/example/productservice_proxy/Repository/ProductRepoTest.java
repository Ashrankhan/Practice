package com.example.productservice_proxy.Repository;

import com.example.productservice_proxy.models.Categories;
import com.example.productservice_proxy.models.Product;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class ProductRepoTest {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private CategoryRepo categoryRepo;
    @Transactional
    @Test
    void saveProductnCategory() {
        Categories categories = new Categories();
        categories.setName("Electronics");
        categories.setDescription("Electronics");
        categories = categoryRepo.save(categories);

        Product product = new Product();
        product.setTitle("Laptop");
        product.setDescription("Laptop");
        product.setCategory(categories);
        productRepo.save(product);

        Categories categories1 = categoryRepo.findById(categories.getId()).get();
        System.out.println("debug");

    }
    @Transactional
    @Test
    void saveProductnCategory1() {
        Product product = new Product();
        product.setTitle("Laptop");
        product.setDescription("Laptop");
        productRepo.save(product);

        Categories categories = new Categories();
        categories.setName("Electronics");
        categories.setDescription("Electronics");
        categories.setProductlist(List.of(product));
        categories = categoryRepo.save(categories);

        Categories categories1 = categoryRepo.findById(categories.getId()).get();
        List<Product> productList = categories1.getProductlist();
        System.out.println("Debug");





    }
    @Transactional
    @Test
    void saveProductnCategory2() {
        Categories categories = new Categories();
        categories.setName("Electronics");
        categories.setDescription("Electronics");
//        categories = categoryRepo.save(categories);

        Product product = new Product();
        product.setTitle("Laptop");
        product.setDescription("Laptop");
        product.setCategory(categories);
        productRepo.save(product);

        Categories categories1 = categoryRepo.findById(categories.getId()).get();
        System.out.println("debug");





    }
 @Test
 @Transactional
 @Rollback(value = false)
    void saveProductsAndCategory3() {
        Categories category = categoryRepo.findById(2L);

        Product product = new Product();
        product.setPrice(1012);
        product.setImage("hiii");
        product.setCategory(category);
        Product savedProduct = productRepo.save(product);

        product = new Product();
        product.setPrice(103);
        product.setImage("hiii");
        product.setCategory(category);
        productRepo.save(product);


    }


}