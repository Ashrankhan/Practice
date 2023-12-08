package com.example.productservice_proxy.dto;

import com.example.productservice_proxy.models.Categories;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Productdto {
    private Long id;
    private String title;
    private double price;
    private String description;

    private String image;
    private String category;
    private ratingDTO ratingdto;
}
//    private long productID;
//    private String title;
//    private double price;
//    private String description;
//    private Categories category;
//    private String image;


// "id": 1,
//         "title": "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
//         "price": 109.95,
//         "description": "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
//         "category": "men's clothing",
//         "image": "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
//         "rating": {
//         "rate": 3.9,
//         "count": 120
//         }
