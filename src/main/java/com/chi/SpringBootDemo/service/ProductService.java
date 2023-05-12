package com.chi.SpringBootDemo.service;

import com.chi.SpringBootDemo.dto.ProductRequest;
import com.chi.SpringBootDemo.entity.Product;
import com.chi.SpringBootDemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public ProductRequest addProduct1(ProductRequest productRequest){
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setQuantity(productRequest.getQuantity());
        product.setSkuCode(productRequest.getSkuCode());

        Product savedProduct = productRepository.save(product);
        ProductRequest response = new ProductRequest();
        response.setName(product.getName());
        response.setDescription(product.getDescription());
        response.setQuantity(product.getQuantity());
        response.setSkuCode(product.getSkuCode());
        return response;
    }

    public ProductRequest addProduct(ProductRequest productRequest){
        Product newProduct = new Product();
        newProduct.setName(productRequest.getName());
        newProduct.setQuantity(productRequest.getQuantity());
        newProduct.setSkuCode(productRequest.getSkuCode());
        newProduct.setDescription(productRequest.getDescription());

        Product savedProduct =  productRepository.save(newProduct);
        return mapToDto(savedProduct);
    }


    public List<Product> fetchAllProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> fetchById(Long productId){
        return productRepository.  findById(productId);
    }

    public Product fetchProductName(String productName){
        boolean isProductExist = productRepository.existsByName(productName);
        if(isProductExist){
           return productRepository.findProductByName(productName);
        }else {
            return null;
        }
    }

    public ProductRequest updateProduct(Long id, ProductRequest productRequest){
        Product updateProduct = productRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        updateProduct.setName(productRequest.getName());
        updateProduct.setDescription(productRequest.getDescription());
        updateProduct.setQuantity(productRequest.getQuantity());
        updateProduct.setSkuCode(productRequest.getSkuCode());

        Product updatedProduct = productRepository.save(updateProduct);
        return mapToDto(updatedProduct);
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    public ProductRequest findByDateCreated(LocalDateTime date){
        return mapToDto(productRepository.findByCreatedAt(date));
    }

    public ProductRequest mapToDto(Product product){
        ProductRequest response = new ProductRequest();
        response.setName(product.getName());
        response.setSkuCode(product.getSkuCode());
        response.setQuantity(product.getQuantity());
        response.setDescription(product.getDescription());
        return response;
    }



    //update and delete and also findByDate

//    public List<ProductRequest> fetchAllProducts(){
//        for(List product: Product)
//
//    }
}
