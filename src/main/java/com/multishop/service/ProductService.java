package com.multishop.service;

import java.util.List;

import com.multishop.model.dto.ProductDTO;
import com.multishop.model.response.ProductReponse;

public interface ProductService {

	List<ProductReponse> getAllProducts();
	ProductDTO getProductById(Long id);
}
