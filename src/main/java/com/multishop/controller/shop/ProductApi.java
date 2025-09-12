package com.multishop.controller.shop;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multishop.model.response.ProductResponse;
import com.multishop.payload.ApiResponse;
import com.multishop.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/shop")
public class ProductApi {

	private final ProductService productService;

	@GetMapping("/product/{id}")
	public ResponseEntity<ApiResponse<ProductResponse>> getProductById(@PathVariable Long id) {
		ProductResponse productResponse = productService.getProductById(id);

		if (productResponse == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Not found product by id: " + id, null));
		}

		return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(), "SUCCESS", productResponse));
	}

}
