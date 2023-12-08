package com.example.productservice_proxy.Clients.Client;

import com.example.productservice_proxy.Clients.DTO.FakeStoreDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
@Component
public class FakeStoreClient {
    private RestTemplateBuilder restTemplateBuilder;
    public FakeStoreClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder=restTemplateBuilder;
    }
    public List<FakeStoreDto> getAllProducts() {
        RestTemplate restTemplate=restTemplateBuilder.build();
       ResponseEntity<FakeStoreDto[]> fakestoredto=restTemplate.getForEntity("https://fakestoreapi.com/products", FakeStoreDto[].class);

       return Arrays.asList(fakestoredto.getBody());
    }
    public FakeStoreDto getSingleProduct(Long productID){
        RestTemplate restTemplate=restTemplateBuilder.build();
       ResponseEntity<FakeStoreDto> fakestoredto=restTemplate.getForEntity("https://fakestoreapi.com/products/{id}",FakeStoreDto.class,productID);
       return fakestoredto.getBody();
    }




}
