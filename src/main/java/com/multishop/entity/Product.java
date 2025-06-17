package com.multishop.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product extends Base {

	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "origin_price")
	private Double originPrice;
	
	@Column(name = "sale_price")
	private Double salePrice;
	
	@Column(name = "sale_quantity")
	private Long saleQuantity;
	
	@Column(name = "discount")
	private Float discount;
	
	@Column(name = "stock")
	private Integer stock;
	
	@ManyToOne 
	@JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<ProductImage> images;

    @OneToMany(mappedBy = "product")
    private List<ProductAttributeValue> attributeValues;
	
    @ManyToOne
    @JoinColumn(name = "shop_id")
	private Shop shop;
}
