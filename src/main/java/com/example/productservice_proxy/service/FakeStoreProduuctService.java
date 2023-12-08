package com.example.productservice_proxy.service;

import com.example.productservice_proxy.Clients.Client.FakeStoreClient;
import com.example.productservice_proxy.Clients.DTO.FakeStoreDto;
import com.example.productservice_proxy.dto.Productdto;
import com.example.productservice_proxy.dto.ratingDTO;
import com.example.productservice_proxy.models.Categories;
import com.example.productservice_proxy.models.Product;
import lombok.ToString;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@ToString

public class FakeStoreProduuctService implements IProductservice {

    RestTemplateBuilder restTemplateBuilder;
    final FakeStoreClient fakestoreclient;

    FakeStoreProduuctService(RestTemplateBuilder restTemplateBuilder,FakeStoreClient fakestoreclient){
        this.restTemplateBuilder=restTemplateBuilder;
        this.fakestoreclient=fakestoreclient;

    }

    @Override
    public Product getSingleProduct(Long productID){

//               RestTemplate restTemplate=restTemplateBuilder.build();
//        ResponseEntity<FakeStoreDto> fakestoredto=restTemplate.getForEntity("https://fakestoreapi.com/products/{id}",FakeStoreDto.class,productID);
        FakeStoreDto fakestoredto=fakestoreclient.getSingleProduct(productID);
        Product product = getProduct(fakestoredto);


        return product;
    }

    private static Product getProduct(FakeStoreDto fakestoredto) {
        Product product=new Product();
        product.setId(fakestoredto.getId());
        product.setTitle(fakestoredto.getTitle());
        product.setPrice(fakestoredto.getPrice());
        product.setDescription(fakestoredto.getDescription());
        product.setImage(fakestoredto.getImage());
        ratingDTO ratingdto=new ratingDTO();
        Categories category=new Categories();
        category.setName(fakestoredto.getCategory());
        product.setCategory(category);

        return product;


    }

    @Override
    public List<Product> getAllProducts(){

//        RestTemplate restTemplate=restTemplateBuilder.build();
//        ResponseEntity<FakeStoreDto[]> fakestoredto=restTemplate.getForEntity("https://fakestoreapi.com/products", FakeStoreDto[].class);
        List<FakeStoreDto> fakestoredto = fakestoreclient.getAllProducts();
        List<Product> answer=new ArrayList<>();
      for(FakeStoreDto fakestoredto1:fakestoredto){
          Product product=new Product();
          product.setId(fakestoredto1.getId());
          product.setTitle(fakestoredto1.getTitle());
          product.setPrice(fakestoredto1.getPrice());
          product.setDescription(fakestoredto1.getDescription());
          product.setImage(fakestoredto1.getImage());
          Categories category=new Categories();
          category.setName(fakestoredto1.getCategory());
          product.setCategory(category);
          answer.add(product);

      }
      return answer;
    }

    @Override
    public Product addNewproduct(Product product) {
        return null;
    }



//       FakeStoreDto fakestoredto=new FakeStoreDto();
//        fakestoredto.setId(productdto.getId());
//         fakestoredto.setTitle(productdto.getTitle());
//            fakestoredto.setPrice(productdto.getPrice());
//            fakestoredto.setDescription(productdto.getDescription());
//            fakestoredto.setImage(productdto.getImage());
//            fakestoredto.setCategory(productdto.getCategory());
//            RestTemplate restTemplate = restTemplateBuilder.build();
//        restTemplate.postForEntity("https://fakestoreapi.com/products", fakestoredto,FakeStoreDto.class);
//         Product answer=getProduct(fakestoredto);
//         return answer;

//    public Product UpdateProduct(Long productId,Productdto productDto){
//
//        RestTemplate restTemplate=restTemplateBuilder.build();
//        FakeStoreDto fakeStoreProductDto = new FakeStoreDto();
//        fakeStoreProductDto.setDescription(productDto.getDescription());
//        fakeStoreProductDto.setImage(productDto.getImage());
//        fakeStoreProductDto.setPrice(productDto.getPrice());
//        fakeStoreProductDto.setTitle(productDto.getTitle());
////        fakeStoreProductDto.setCategory(productDto.getCategory()
//
////        ResponseEntity<FakeStoreDto> fakeStoreProductDtoResponseEntity
////                = requestForEntity(
////                HttpMethod.PATCH,
////                "https://fakestoreapi.com/products/{id}",
////                fakeStoreProductDto,
////                FakeStoreDto.class,
////                productId
////        );
////        );


    }
