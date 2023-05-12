package com.chi.SpringBootDemo.controller;

import com.chi.SpringBootDemo.dto.ProductRequest;
import com.chi.SpringBootDemo.entity.Product;
import com.chi.SpringBootDemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
    @RequestMapping("/api/product")
public class ProductController {
        @Autowired
        ProductService productService;

    @PostMapping
    public ProductRequest addProduct(@RequestBody ProductRequest productRequest){
       return productService.addProduct(productRequest);
    }

    @GetMapping
    public List<Product> fetchAllProducts(){
        return  productService.fetchAllProducts();
    }

   @GetMapping("/{productId}")
    public Optional<Product> fetchById(@PathVariable(value = "productId") Long productId){
        return productService.fetchById(productId);
    }

    @GetMapping("/productName")
    public Product fetchProductByName(@RequestParam(name = "productName", required = true) String productName){
        return productService.fetchProductName(productName);
    }

    @PutMapping("/{id}")
    public ProductRequest UpdateProduct(@PathVariable(value = "id", required = true) Long id, @RequestBody ProductRequest productRequest){
        return productService.updateProduct(id,productRequest);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(Long id){
       productService.deleteProduct(id);
        return "Product successfully deleted";
    }

    @GetMapping("/date")
    public ProductRequest findByDateCreated(@RequestParam("date") LocalDateTime date){
       return productService.findByDateCreated(date);
    }
}

