package com.example.productservice_proxy.service;

import com.example.productservice_proxy.dto.Productdto;
import com.example.productservice_proxy.models.Product;

import java.util.List;

public interface IProductservice {
    Product getSingleProduct(Long productID);

    List<Product> getAllProducts();

    Product addNewproduct(Product product);
}
