package com.multishop.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class CategoryEntity extends BaseEntity {
	
	@Column(name = "category_nm")
	private String categoryName;
	
	@Column(name = "image_path")
	private String imagePath;
	
	@ManyToOne
	@JoinColumn(name = "parent_id")
	private CategoryEntity parent;
	
	@OneToMany(mappedBy = "parent")
	private List<CategoryEntity> childden;
	
}
