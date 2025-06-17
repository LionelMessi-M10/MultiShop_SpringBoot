package com.multishop.model.dto;

import java.util.List;

import lombok.Data;

@Data
public class CategoryDTO {

	private Long id;
	private String categoryName;
	private List<SubCategoryDTO> subCategorys;
}
