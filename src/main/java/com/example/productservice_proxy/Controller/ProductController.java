package com.example.productservice_proxy.Controller;

import com.example.productservice_proxy.Clients.DTO.FakeStoreDto;
import com.example.productservice_proxy.dto.Productdto;
import com.example.productservice_proxy.dto.ratingDTO;
import com.example.productservice_proxy.models.Categories;
import com.example.productservice_proxy.models.Product;
import com.example.productservice_proxy.service.IProductservice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//this controller will answer for / controller
@RestController
@RequestMapping("/products")
public class ProductController {
    IProductservice productservice;
    ProductController(IProductservice productservice){
        this.productservice=productservice;
    }
    @GetMapping("")
    public ResponseEntity<List<Product>> getALLProduct() {
        return new ResponseEntity<>(this.productservice.getAllProducts(), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleproduct(@PathVariable("id") Long productID) {
        try{
            MultiValueMap<String,String> headers=new LinkedMultiValueMap<>();
            headers.add("Accept","Application/XML");
            headers.add("connection","keep-alive");
//            headers.add("auth-token","1233434");
            Product product =this.productservice.getSingleProduct(productID);
            if(productID<1){
                throw new IllegalArgumentException("Wrong input");
            }
       ResponseEntity<Product> responseentity=new ResponseEntity<>(product,headers, HttpStatus.OK);
        return responseentity;
        }
        catch(Exception e){
            throw e;
        }

    }

    @PostMapping("")
        public ResponseEntity<Product> addnewProduct(@RequestBody Productdto productdto) {

//        Product product=this.productservice.addNewproduct(productdto);
//        ResponseEntity<Product> responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
//        return responseEntity;
        Product product=getProduct(productdto);
        Product savedproduct=this.productservice.addNewproduct(product);
        ResponseEntity<Product> responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
        return responseEntity;

    }
    Product getProduct(Productdto fakestoredto) {
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

//    public ResponseEntity<Product> addNewProduct(@RequestBody ProductDto productDto) {
//        Product product = getProduct(productDto);
//        Product savedproduct = this.productService.addNewProduct(product);
//        ResponseEntity<Product> responseEntity = new ResponseEntity<>(savedproduct, HttpStatus.OK);
//        return responseEntity;
//    }

//    @PutMapping("/{productID}")
//    public String updateProduct(@PathVariable("productID") Long productID) {
//        return "Updating product : " + productID;
//    }

    @DeleteMapping("/{productID}")
        public String deleteProduct (@PathVariable("productID") Long productID){
            return "deleting product : " + productID;
        }

//    @ExceptionHandler({NullPointerException.class,IllegalArgumentException.class})
//        public ResponseEntity<String> Exceptionhandle(Exception e){
//        return new ResponseEntity<>("kuch to phata hai",HttpStatus.BAD_REQUEST);
//        }



    }
