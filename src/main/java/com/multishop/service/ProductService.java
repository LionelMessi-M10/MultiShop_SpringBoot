package com.multishop.service;

import java.util.List;

import com.multishop.model.response.ProductReponse;

public interface ProductService {

	List<ProductReponse> getAllProducts();
}
