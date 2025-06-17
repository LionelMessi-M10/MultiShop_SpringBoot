package com.multishop.model.dto;

import java.util.List;

import lombok.Data;

@Data
public class ProductDTO {

	private Long id;
	private String name;
	private String description;
	private Double originPrice;
	private Double salePrice;
	private Long saleQuantity;
	private Float discount;
	private Integer stock;
	private Byte status;
	private CategoryDTO categoryDTO;
	private List<ProductImageDTO> productImages;
	private List<ProductAttributeValueDTO> attributeValues;
	
}
