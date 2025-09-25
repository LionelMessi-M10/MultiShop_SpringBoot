package com.multishop.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "categories")
public class Category extends Base {

	@NotNull
	@Column(name = "name", unique = true)
	private String name;

	@Column(name = "image")
	private String image;

	@OneToMany(mappedBy = "category")
	private List<SubCategory> subCategories;

	@OneToMany(mappedBy = "category", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	private List<Product> products;

	@ManyToOne
	@JoinColumn(name = "shop_id")
	private Shop shop;

}
