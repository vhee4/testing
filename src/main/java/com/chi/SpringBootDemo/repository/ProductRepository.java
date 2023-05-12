package com.chi.SpringBootDemo.repository;

import com.chi.SpringBootDemo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
//    Optional<Product> findById(Long id);
    Product findProductByName(String productName);
    Boolean existsByName(String productName);
    Product existsByCreatedAt(LocalDateTime dateTime);
    Product findByCreatedAt(LocalDateTime dateTime);
}
