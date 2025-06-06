package com.multishop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product_attribute_values")
@Getter 
@Setter
public class ProductAttributeValue {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne 
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @ManyToOne @JoinColumn(name = "attribute_id")
    private Attribute attribute;

    private String value;
}
