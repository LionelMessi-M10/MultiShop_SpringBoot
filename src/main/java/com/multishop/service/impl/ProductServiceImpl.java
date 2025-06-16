package com.multishop.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multishop.converter.ProductConverter;
import com.multishop.model.response.ProductReponse;
import com.multishop.repository.ProductRepository;
import com.multishop.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductConverter productConverter;

	@Override
	public List<ProductReponse> getAllProducts() {

		List<ProductReponse> res = productRepository.findAll().stream()
				.map(item -> productConverter.convertEntityToReponse(item)).collect(Collectors.toList());

		return res;
	}

}
