package com.multishop.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product_images")
@Getter @Setter
public class ProductImage extends Base {
	
    private String url;
    private Boolean isThumbnail;

    @ManyToOne 
    @JoinColumn(name = "product_id")
    private Product product;
}

