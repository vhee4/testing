package com.chi.SpringBootDemo.dto;

import jakarta.persistence.*;
import lombok.*;

@Data
public class ProductRequest {
        private String name;
        private Integer quantity;
        private String skuCode;
        private String description;
}
