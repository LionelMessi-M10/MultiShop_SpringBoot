package com.multishop.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoryResponse {

	private Long id;
	private String name;
	private String image;
	private Byte status;
	private Long categoryParentId;
	private String categoryParentName;
	private Long shopId;
	private String shopName;
	
}
