package com.multishop.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.multishop.model.dto.ProductDTO;
import com.multishop.service.ProductService;

@RestController("/api/admin")
public class ProductApi {
	
	@Autowired
	private ProductService productService;

	@GetMapping("/product")
	public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
		ProductDTO productDTO = new ProductDTO();
		
		return ResponseEntity.ok(productDTO);
	}
}
