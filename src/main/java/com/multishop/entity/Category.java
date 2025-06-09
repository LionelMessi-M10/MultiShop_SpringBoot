package com.multishop.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
	
	@OneToMany(mappedBy = "category")
	private List<SubCategory> subCategories;
}
