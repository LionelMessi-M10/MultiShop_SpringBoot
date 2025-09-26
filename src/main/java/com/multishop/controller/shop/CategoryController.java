package com.multishop.controller.shop;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.multishop.model.response.CategoryResponse;
import com.multishop.payload.ApiResponse;
import com.multishop.service.CategoryService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/shop")
public class CategoryController {

	private final CategoryService categoryService;
	
	@GetMapping("/all")
	public ResponseEntity<ApiResponse> getAllCategories(
	        @RequestParam(name = "pageNo", defaultValue = "0") int pageNo,
	        @RequestParam(name = "pageSize", defaultValue = "10") int pageSize) {

	    Page<CategoryResponse> result = categoryService.getAll(pageNo, pageSize);

	    return ResponseEntity.ok(
	        ApiResponse.success(
	            HttpStatus.OK,
	            result,
	            "Get all categories successfully"
	        )
	    );
	}

	
	
}
