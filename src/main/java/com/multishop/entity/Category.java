package com.multishop.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "categories")
public class Category extends Base {
	
	@Column(name = "category_nm")
	private String categoryName;
	
	@Column(name = "image")
	private String image;
	
	@OneToMany(mappedBy = "categories", fetch = FetchType.LAZY)
	private List<Product> products;
	
	@OneToMany(mappedBy = "category")
	private List<SubCategory> subCategories;
	
	@ManyToOne
	@JoinColumn(name = "seller_id")
	private Shop shop;
	
}
