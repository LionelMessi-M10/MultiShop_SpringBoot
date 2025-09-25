package com.multishop.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "sub_categories")
public class SubCategory extends Base {

	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "parent_id")
	private Category category;
	
	@OneToMany(mappedBy = "subCategory", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
	private List<Product> products;
}
