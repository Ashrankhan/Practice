package com.example.productservice_proxy.service;

import com.example.productservice_proxy.Repository.ProductRepo;
import com.example.productservice_proxy.dto.Productdto;
import com.example.productservice_proxy.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class SelfService implements IProductservice{
    ProductRepo productRepo;
    public SelfService(ProductRepo productRepo){
        this.productRepo = productRepo;
    }
    @Override
    public Product getSingleProduct(Long productID) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product addNewproduct(Product product) {
        this.productRepo.save(product);
        return product;
    }

}
