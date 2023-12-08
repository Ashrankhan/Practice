package com.example.productservice_proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//proxy service is just a delagator between the client and other service.
@SpringBootApplication
public class ProductServiceProxyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceProxyApplication.class, args);
    }

}
