package com.multishop.entity;

import com.multishop.enums.ProductAttributeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "attributes")
@Getter 
@Setter
public class Attribute {
	
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name; // Màu sắc, kích thước, chất liệu, ...
    
    @Column(name = "product_attribute_value")
    @Enumerated(EnumType.STRING)
    private Enum<ProductAttributeType> productAttribute;
}
