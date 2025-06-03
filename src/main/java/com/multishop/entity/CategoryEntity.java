package com.multishop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity {

	@Column(name = "category_cd")
	private String categoryCode;
	
	@Column(name = "category_nm")
	private String categoryName;
	
	@Column(name = "image_path")
	private String imagePath;
	
}
